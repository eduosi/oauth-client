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

import java.util.Date;

import org.scribe.up.profile.AttributesDefinition;

import com.buession.oauth.profile.BaseOAuthProfile;
import com.buession.oauth.profile.OAuthAttributesDefinitions;

/**
 * 支付宝 OpenId Profile
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class AlipayProfile extends BaseOAuthProfile {

	private static final long serialVersionUID = 1230102489548638510L;

	@Override
	public String getUsername() {
		return null;
	}

	/**
	 * 返回通知校验 ID
	 * 
	 * @return 通知校验 ID
	 */
	public String getNotifyId() {
		return (String) get(AlipayAttributesDefinition.NOTIFY_ID);
	}

	/**
	 * 返回用户 ID
	 * 
	 * @return 用户 ID
	 */
	@Override
	public String getId() {
		return (String) get(AlipayAttributesDefinition.ID);
	}

	/**
	 * 返回用户 ID
	 * 
	 * @return 用户 ID
	 */
	public String getUserId() {
		return (String) get(AlipayAttributesDefinition.USER_ID);
	}

	/**
	 * 返回用户支付宝用户姓名或淘宝用户名
	 * 
	 * @return 用户支付宝用户姓名或淘宝用户名
	 */
	@Override
	public String getRealName() {
		return (String) get(AlipayAttributesDefinition.REAL_NAME);
	}

	/**
	 * 返回用户等级
	 * 
	 * @return 用户等级
	 */
	public String getUserGrade() {
		return (String) get(AlipayAttributesDefinition.USER_GRADE);
	}

	/**
	 * 返回用户等级类型
	 * 
	 * @return 用户等级类型
	 */
	public Integer getUserGradeType() {
		return (Integer) get(AlipayAttributesDefinition.USER_GRADE_TYPE);
	}

	/**
	 * 返回用户等级衰减时间
	 * 
	 * @return 用用户等级衰减时间
	 */
	public Date getGmtDecay() {
		return (Date) get(AlipayAttributesDefinition.GMT_DECAY);
	}

	/**
	 * 返回目标商户跳转结果页面
	 * 本参数是在买家通过etao进来时获取到的，一般为目标商户网站的商品详情页面。
	 * 
	 * @return 目标商户跳转结果页面
	 */
	public String getTargetUrl() {
		return (String) get(AlipayAttributesDefinition.TARGET_URL);
	}

	@Override
	protected AttributesDefinition getAttributesDefinition() {
		return OAuthAttributesDefinitions.alipayDefinition;
	}

}