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
package com.buession.oauth.profile.alipay;

import java.util.Locale;

import org.scribe.up.profile.AttributesDefinition;
import org.scribe.up.profile.converter.Converters;
import org.scribe.up.profile.converter.FormattedDateConverter;

/**
 * 支付宝用户属性表
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class AlipayAttributesDefinition extends AttributesDefinition {

	/**
	 * 通知校验 ID
	 */
	public final static String NOTIFY_ID = "notify_id";

	/**
	 * 用户 ID
	 */
	public final static String ID = "id";

	/**
	 * 用户 ID
	 */
	public final static String USER_ID = "user_id";

	/**
	 * 用户名
	 */
	public final static String USERNAME = "username";

	/**
	 * 支付宝用户姓名或淘宝用户名
	 */
	public final static String REAL_NAME = "real_name";

	/**
	 * 用户 E-mail
	 */
	public final static String EMAIL = "email";

	/**
	 * 用户等级
	 */
	public final static String USER_GRADE = "user_grade";

	/**
	 * 用户等级类型
	 */
	public final static String USER_GRADE_TYPE = "user_grade_type";

	/**
	 * 用户等级衰减时间
	 */
	public final static String GMT_DECAY = "gmt_decay";

	/**
	 * 目标商户跳转结果页面
	 * 本参数是在买家通过etao进来时获取到的，一般为目标商户网站的商品详情页面。
	 */
	public final static String TARGET_URL = "target_url";

	private final static FormattedDateConverter formattedDateConverter = new FormattedDateConverter(
			"yyyy-MM-dd", Locale.US);

	public AlipayAttributesDefinition() {
		addAttribute(NOTIFY_ID, Converters.stringConverter);
		addAttribute(ID, Converters.stringConverter);
		addAttribute(USER_ID, Converters.stringConverter);
		addAttribute(USERNAME, Converters.stringConverter);
		addAttribute(REAL_NAME, Converters.stringConverter);
		addAttribute(EMAIL, Converters.stringConverter);
		addAttribute(USER_GRADE, Converters.stringConverter);
		addAttribute(USER_GRADE_TYPE, Converters.integerConverter);
		addAttribute(GMT_DECAY, formattedDateConverter);
		addAttribute(TARGET_URL, Converters.stringConverter);
	}

}