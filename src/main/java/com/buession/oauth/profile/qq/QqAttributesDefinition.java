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

import org.scribe.up.profile.converter.Converters;
import org.scribe.up.profile.converter.GenderConverter;

import com.buession.oauth.profile.OAuthAttributesDefinition;

/**
 * QQ OAuth attributes definition
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class QqAttributesDefinition extends OAuthAttributesDefinition {

	/**
	 * 用户昵称
	 */
	public final static String OPEN_ID = "openid";

	/**
	 * 用户名
	 */
	public final static String USERNAME = "username";

	/**
	 * 用户昵称
	 */
	public final static String NICKNAME = "nickname";

	/**
	 * 用户性别
	 */
	public final static String GENDER = "gender";

	/**
	 * 大小为 40×40 像素的 QQ 头像 URL
	 */
	public final static String FIGUREURL_QQ_1 = "figureurl_qq_1";

	/**
	 * 大小为 100×100 像素的 QQ头像URL。需要注意，不是所有的用户都拥有 QQ 的100x100 的头像
	 */
	public final static String FIGUREURL_QQ_2 = "figureurl_qq_2";

	private final static GenderConverter genderConverter = new GenderConverter("男", "女");

	public QqAttributesDefinition() {
		addAttribute(OPEN_ID, Converters.stringConverter);
		addAttribute(USERNAME, Converters.stringConverter);
		addAttribute(NICKNAME, Converters.stringConverter);
		addAttribute(GENDER, genderConverter);
		addAttribute(FIGUREURL_QQ_1, Converters.stringConverter);
		addAttribute(FIGUREURL_QQ_2, Converters.stringConverter);
	}

}