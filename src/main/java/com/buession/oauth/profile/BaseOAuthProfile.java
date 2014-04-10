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
package com.buession.oauth.profile;

import java.util.Locale;
import java.util.Map;

import org.scribe.up.profile.AttributesDefinition;

import com.buession.open.profile.Profile;
import com.buession.open.utils.Gender;

/**
 * 用户 Profile 基类
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public abstract class BaseOAuthProfile extends org.scribe.up.profile.BaseOAuthProfile implements
		Profile {

	private static final long serialVersionUID = -5595368391979364076L;

	/**
	 * 返回用户 e-mail
	 * 
	 * @return 用户e-mail
	 */
	@Override
	public String getEmail() {
		return null;
	}

	/**
	 * 返回用户真实姓名
	 * 
	 * @return 用户真实姓名
	 */
	@Override
	public String getRealName() {
		return null;
	}

	/**
	 * 返回用户名字
	 * 
	 * @return 用户名字
	 */
	@Override
	public String getFirstName() {
		return null;
	}

	/**
	 * 返回用户姓氏
	 * 
	 * @return 用户姓氏
	 */
	@Override
	public String getFamilyName() {
		return null;
	}

	/**
	 * 返回用户显示名称
	 * 依次顺序是：真实姓名，名字+姓氏，用户名
	 * 
	 * @return 用户显示名称
	 */
	@Override
	public String getDisplayName() {
		String realName = getRealName();

		if (realName == null || realName.length() == 0) {
			String firstName = getFirstName();
			if (firstName == null) {
				return getUsername();
			} else {
				String familyName = getFamilyName();
				return familyName == null ? firstName : firstName + " " + familyName;
			}
		} else {
			return realName;
		}
	}

	/**
	 * 返回用户性别
	 * 
	 * @return 用户性别
	 */
	@Override
	public Gender getGender() {
		return null;
	}

	/**
	 * 返回用户资料页地址
	 * 
	 * @return 用户资料页地址
	 */
	@Override
	public String getProfileUrl() {
		return null;
	}

	/**
	 * 返回用户头像地址
	 * 
	 * @return 用户头像地址
	 */
	@Override
	public String getAvatar() {
		return null;
	}

	/**
	 * 返回用户头像地址
	 * 
	 * @return 用户头像地址
	 */
	@Override
	public final String getPictureUrl() {
		return getAvatar();
	}

	/**
	 * Return the locale of the user.
	 * 
	 * @return the locale of the user
	 */
	@Override
	public Locale getLocale() {
		return null;
	}

	/**
	 * 返回用户国家
	 * 
	 * @return 用户国家
	 */
	@Override
	public String getCountry() {
		return null;
	}

	/**
	 * 返回用户省份
	 * 
	 * @return 用户省份
	 */
	@Override
	public String getProvince() {
		return null;
	}

	/**
	 * 返回用户城市
	 * 
	 * @return 用户城市
	 */
	@Override
	public String getCity() {
		return null;
	}

	/**
	 * 返回用户联系地址
	 * 
	 * @return 用户联系地址
	 */
	@Override
	public String getAddress() {
		return null;
	}

	/**
	 * 返回用户联系地址
	 * 
	 * @return 用户联系地址
	 */
	@Override
	public final String getLocation() {
		return getAddress();
	}

	/**
	 * 返回用户是否是 VIP 用户
	 * 
	 * @return 用户是否是 VIP 用户
	 */
	@Override
	public boolean getIsVip() {
		return false;
	}

	/**
	 * 返回用户属性
	 * 
	 * @param name
	 *        属性名称
	 * @return 用户属性
	 */
	@Override
	public Object getAttribute(String name) {
		return get(name);
	}

	/**
	 * 返回 Profile 所有属性
	 * 
	 * @return Profile 所有属性
	 */
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * 返回用户资料属性属性定义
	 * 
	 * @return 用户资料属性属性定义
	 */
	@Override
	protected AttributesDefinition getAttributesDefinition() {
		return null;
	}

}