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

import org.scribe.model.OAuthConfig;
import org.scribe.model.SignatureType;
import org.scribe.up.addon_to_scribe.ExtendedOAuth20ServiceImpl;
import org.scribe.up.profile.JsonHelper;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;

import com.buession.oauth.api.WeiboApi;
import com.buession.oauth.profile.OAuthAttributesDefinitions;
import com.buession.oauth.profile.weibo.WeiboAttributesDefinition;
import com.buession.oauth.profile.weibo.WeiboProfile;
import com.buession.oauth.scope.WeiboScope;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 新浪微博 OAuth Provider
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class WeiboProvider extends BaseOAuth20Provider {

	/**
	 * scope是OAuth2.0授权机制中authorize接口的一个参数
	 * 通过scope，平台将开放更多的微博核心功能给开发者，同时也加强用户隐私保护，提升了用户体验，用户在新OAuth2.0授权页中有权利选择赋予应用的功能。
	 */
	protected WeiboScope scope = WeiboScope.ALL;

	/**
	 * 设置 WeiboScope
	 * 
	 * @param scope
	 *        WeiboScope
	 */
	public void setScope(WeiboScope scope) {
		this.scope = scope;
	}

	/**
	 * 返回 scope
	 * 
	 * @return
	 */
	public WeiboScope getScope() {
		return scope;
	}

	@Override
	protected WeiboProvider newProvider() {
		WeiboProvider provider = new WeiboProvider();
		provider.setScope(scope);
		logger.debug("request scope: " + scope);

		return provider;
	}

	@Override
	protected void internalInit() {
		service = new ExtendedOAuth20ServiceImpl(new WeiboApi(), new OAuthConfig(key, secret,
				callbackUrl, SignatureType.Header, scope == null ? null : scope.toString(), null),
				proxyHost, proxyPort);
	}

	@Override
	protected String getProfileUrl() {
		return WeiboApi.BASE_URL + "2/statuses/user_timeline.json";
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		final WeiboProfile profile = new WeiboProfile();
		JsonNode json = JsonHelper.getFirstNode(body);

		if (json != null) {
			JsonNode statuses = json.get("statuses");

			if (statuses != null) {
				JsonNode status = statuses.get(0);

				if (status != null) {
					JsonNode user = status.get("user");

					if (user != null) {
						profile.setId(JsonHelper.get(user, WeiboAttributesDefinition.ID));

						List<String> principalAttributes = OAuthAttributesDefinitions.weiboDefinition
								.getPrincipalAttributes();
						for (final String name : principalAttributes) {
							Object value = JsonHelper.get(user, name);

							profile.addAttribute(name, value);
							if (WeiboAttributesDefinition.SCREEN_NAME.equals(name) == true) {
								profile.addAttribute(WeiboAttributesDefinition.USERNAME, value);
							} else if (WeiboAttributesDefinition.LOCATION.equals(name) == true) {
								profile.addAttribute(WeiboAttributesDefinition.ADDRESS, value);
							}
						}

						Object avatarHd = JsonHelper.get(user, WeiboAttributesDefinition.AVATAR_HD);
						if (avatarHd != null && avatarHd.toString().length() != 0) {
							profile.addAttribute(WeiboAttributesDefinition.AVATAR, avatarHd);
						} else {
							Object avatarLarge = JsonHelper.get(user,
									WeiboAttributesDefinition.AVATAR_LARGE);
							if (avatarLarge != null && avatarLarge.toString().length() != 0) {
								profile.addAttribute(WeiboAttributesDefinition.AVATAR, avatarLarge);
							}
						}
					}
				}
			}
		}

		return profile;
	}

}