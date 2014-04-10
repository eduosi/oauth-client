/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 
 * (the "License"); you may not use this file except in compliance with the License. You may obtain 
 * a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * =================================================================================================
 * 
 * This software consists of voluntary contributions made by many individuals on behalf of the
 * Apache Software Foundation. For more information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 * 
 * +------------------------------------------------------------------------------------------------+
 * | License: http://oauth-client.buession.com.cn/LICENSE 											|
 * | Author: Yong.Teng <webmaster@buession.com> 													|
 * | Copyright @ 2013-2014 Buession.com Inc.														|
 * +------------------------------------------------------------------------------------------------+
 */
package com.buession.oauth.provider.impl;

import java.util.List;

import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthConfig;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.up.credential.OAuthCredential;
import org.scribe.up.profile.JsonHelper;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.BaseOAuthProvider;
import org.scribe.up.provider.exception.HttpException;

import com.buession.oauth.api.QqApi;
import com.buession.oauth.profile.OAuthAttributesDefinitions;
import com.buession.oauth.profile.qq.QqAttributesDefinition;
import com.buession.oauth.profile.qq.QqProfile;
import com.buession.oauth.service.QqOAuth20ServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * QQ OAuth 2.0 Provider
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class QqProvider extends BaseOAuth20Provider {

	/**
	 * Retrieve the user profile from OAuth credential.
	 * 
	 * @param credential
	 * @return the user profile object
	 * @throws HttpException
	 */
	@Override
	public UserProfile retrieveUserProfile(final OAuthCredential credential) throws HttpException {
		init();

		final Token accessToken = getAccessToken(credential);
		return retrieveUserProfile(accessToken);
	}

	@Override
	public UserProfile getUserProfile(final OAuthCredential credential) {
		try {
			return retrieveUserProfile(credential);
		} catch (final HttpException e) {
			return null;
		}
	}

	@Override
	protected BaseOAuthProvider newProvider() {
		return new QqProvider();
	}

	@Override
	protected void internalInit() {
		service = new QqOAuth20ServiceImpl(new QqApi(), new OAuthConfig(key, secret, callbackUrl,
				SignatureType.Header, null, null), proxyHost, proxyPort);
	}

	@Override
	protected String getProfileUrl() {
		return QqApi.BASE_URL + "user/get_user_info";
	}

	/**
	 * 返回获取用户 openid url
	 * 
	 * @return 获取用户 openid url
	 */
	protected String getOpenIdUrl() {
		return QqApi.BASE_URL + "oauth2.0/me";
	}

	/**
	 * Retrieve the user profile from the access token.
	 * 
	 * @param accessToken
	 * @return the user profile object
	 * @throws HttpException
	 */
	@Override
	protected UserProfile retrieveUserProfile(final Token accessToken) throws HttpException {
		String openIdUrl = getOpenIdUrl();
		logger.debug("get openid from: " + openIdUrl);
		String body = sendRequestForData(accessToken, openIdUrl);
		if (body == null) {
			return null;
		}

		String str = body.replace("callback( ", "").replace(" );", "");

		JsonNode json = JsonHelper.getFirstNode(str);
		JsonNode clientid = json.get("client_id");
		JsonNode openid = json.get("openid");

		if (openid == null) {
			throw new OAuthException(
					"Response body is incorrect. Can't extract a openid from this: '" + body + "'",
					null);
		}

		String url = getProfileUrl() + "?oauth_consumer_key=" + clientid.textValue() + "&openid="
				+ openid.textValue();
		logger.debug("get user profile by clientid<" + clientid + "> and openid<" + openid
				+ "> from: " + url);

		body = sendRequestForData(accessToken, url);

		final UserProfile profile = extractUserProfile(body);

		profile.setId(openid.textValue());
		addAccessTokenToProfile(profile, accessToken);

		return profile;
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		final QqProfile profile = new QqProfile();
		JsonNode json = JsonHelper.getFirstNode(body);

		if (json != null) {
			List<String> principalAttributes = OAuthAttributesDefinitions.qqDefinition
					.getPrincipalAttributes();
			for (final String name : principalAttributes) {
				Object value = JsonHelper.get(json, name);
				profile.addAttribute(name, value);

				if (QqAttributesDefinition.NICKNAME.equals(name) == true) {
					profile.addAttribute(QqAttributesDefinition.USERNAME, value);
				}
			}
		}

		return profile;
	}

}