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

import org.scribe.model.OAuthConfig;
import org.scribe.model.SignatureType;
import org.scribe.up.addon_to_scribe.ExtendedOAuth20ServiceImpl;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.BaseOAuthProvider;

import com.buession.oauth.api.AlipayApi;

/**
 * 支付宝Auth Provider
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class AlipayProvider extends BaseOAuth20Provider {

	@Override
	protected BaseOAuthProvider newProvider() {
		return new AlipayProvider();
	}

	@Override
	protected void internalInit() {
		service = new ExtendedOAuth20ServiceImpl(new AlipayApi(), new OAuthConfig(key, secret,
				callbackUrl, SignatureType.Header, null, null), proxyHost, proxyPort);
	}

	@Override
	protected String getProfileUrl() {
		return null;
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		return null;
	}

}