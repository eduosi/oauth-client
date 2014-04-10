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
package com.buession.oauth.profile.qq;

import org.scribe.up.profile.AttributesDefinition;

import com.buession.oauth.profile.BaseOAuthProfile;
import com.buession.oauth.profile.OAuthAttributesDefinitions;
import com.buession.oauth.profile.weibo.WeiboAttributesDefinition;
import com.buession.open.utils.Gender;

/**
 * QQ OAuth profile
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class QqProfile extends BaseOAuthProfile {

	private static final long serialVersionUID = 991316880740957137L;

	/**
	 * Return the openid of the user.
	 * 
	 * @return the openid of the user
	 */
	public String getOpenid() {
		return (String) get(QqAttributesDefinition.OPEN_ID);
	}

	/**
	 * 返回用户在 QQ 空间的昵称
	 * 
	 * @return 用户在 QQ 空间的昵称
	 */
	public String getNickName() {
		return (String) get(QqAttributesDefinition.NICKNAME);
	}

	/**
	 * 返回用户名
	 * 
	 * @return 用户名
	 */
	@Override
	public String getUsername() {
		return getNickName();
	}

	/**
	 * 返回用户性别
	 * 
	 * @return 用户性别
	 */
	@Override
	public Gender getGender() {
		return (Gender) get(WeiboAttributesDefinition.GENDER);
	}

	/**
	 * 返回用户大小为 40×40 像素的 QQ 头像URL
	 * 
	 * @return 用户大小为 40×40 像素的 QQ 头像URL
	 */
	public String getFigureurlQq1() {
		return (String) get(QqAttributesDefinition.FIGUREURL_QQ_1);
	}

	/**
	 * 返回用户大小为 100×100 像素的 QQ 头像URL
	 * 
	 * @return 用户大小为 100×100 像素的 QQ 头像URL
	 */
	public String getFigureurlQq2() {
		return (String) get(QqAttributesDefinition.FIGUREURL_QQ_2);
	}

	/**
	 * 返回用户 QQ 头像URL
	 * 
	 * @return 用户 QQ 头像URL
	 */
	@Override
	public String getAvatar() {
		String figureurlQq1 = getFigureurlQq1();
		return figureurlQq1 != null && figureurlQq1.length() > 0 ? figureurlQq1 : getFigureurlQq2();
	}

	/**
	 * 返回用户资料属性属性定义
	 * 
	 * @return 用户资料属性属性定义
	 */
	@Override
	protected AttributesDefinition getAttributesDefinition() {
		return OAuthAttributesDefinitions.qqDefinition;
	}

}