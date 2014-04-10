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
package com.buession.oauth.profile.weibo;

import java.util.Locale;

import org.scribe.up.profile.OAuthAttributesDefinition;
import org.scribe.up.profile.converter.Converters;
import org.scribe.up.profile.converter.FormattedDateConverter;
import org.scribe.up.profile.converter.GenderConverter;

/**
 * 新浪微博用户信息属性
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class WeiboAttributesDefinition extends OAuthAttributesDefinition {

	/**
	 * 用户 ID
	 */
	public final static String ID = "id";

	/**
	 * 用户名
	 */
	public final static String USERNAME = "username";

	/**
	 * 用户微号
	 */
	public final static String WEIHAO = "weihao";

	/**
	 * 用户昵称
	 */
	public final static String SCREEN_NAME = "screen_name";

	/**
	 * 用户友好显示名称
	 */
	public final static String NAME = "name";

	/**
	 * 用户创建（注册）时间
	 */
	public final static String CREATED_AT = "created_at";

	/**
	 * 用户性别
	 */
	public final static String GENDER = "gender";

	/**
	 * 用户头像地址
	 */
	public final static String AVATAR = "avatar";

	/**
	 * 用户头像地址（大图），180×180像素
	 */
	public final static String AVATAR_LARGE = "avatar_large";

	/**
	 * 用户高清原图头像地址
	 */
	public final static String AVATAR_HD = "avatar_hd";

	/**
	 * 是否是微博认证用户，即加V用户，true：是，false：否
	 */
	public final static String VERIFIED = "verified";

	/**
	 * 
	 */
	@Deprecated
	public final static String VERIFIED_TYPE = "verified_type";

	/**
	 * 用户认证原因
	 */
	public final static String VERIFIED_REASON = "verified_reason";

	/**
	 * 用户所在省级份
	 */
	public final static String PROVINCE = "province";

	/**
	 * 用户所在城市
	 */
	public final static String CITY = "city";

	/**
	 * 用户联系地址
	 */
	public final static String ADDRESS = "address";

	/**
	 * 用户联系地址
	 */
	public final static String LOCATION = "location";

	/**
	 * 用户的个性化域名
	 */
	public final static String DOMAIN = "domain";

	/**
	 * 用户的微博地址
	 */
	public final static String PROFILE_URL = "profileUrl";

	/**
	 * 用户博客地址
	 */
	public final static String BLOG_URL = "url";

	/**
	 * 该用户是否关注当前登录用户，true：是，false：否
	 */
	public final static String FOLLOW_ME = "follow_me";

	/**
	 * 粉丝数
	 */
	public final static String FOLLOWERS_COUNT = "followers_count";

	/**
	 * 用户的互粉数
	 */
	public final static String BI_FOLLOWERS_COUNT = "bi_followers_count";

	/**
	 * 关注数
	 */
	public final static String FRIENDS_COUNT = "friends_count";

	/**
	 * 微博数
	 */
	public final static String STATUSES_COUNT = "statuses_count";

	/**
	 * 收藏数
	 */
	public final static String FAVOURITES_COUNT = "favourites_count";

	/**
	 * 
	 */
	@Deprecated
	public final static String IS_FOLLOWING = "following";

	/**
	 * 是否允许所有人给我发私信，true：是，false：否
	 */
	public final static String ALLOW_ALL_ACT_MSG = "allow_all_act_msg";

	/**
	 * 是否允许标识用户的地理位置，true：是，false：否
	 */
	public final static String GEO_ENABLED = "geo_enabled";

	/**
	 * 是否允许所有人对我的微博进行评论，true：是，false：否
	 */
	public final static String ALLOW_ALL_COMMENT = "allow_all_comment";

	/**
	 * 用户的在线状态，0：不在线、1：在线
	 */
	public final static String IS_ONLINE = "online_status";

	/**
	 * 用户当前的语言版本
	 */
	public final static String LANG = "lang";

	/**
	 * 用户个人备注
	 */
	public final static String REMARK = "remark";

	/**
	 * 用户个人描述
	 */
	public final static String DESCRIPTION = "description";

	private final static ProfileUrlConverter profileUrlConverter = new ProfileUrlConverter();

	private final static FormattedDateConverter formattedDateConverter = new FormattedDateConverter(
			"EEE MMM dd HH:mm:ss Z yyyy", Locale.US);

	private final static GenderConverter genderConverter = new GenderConverter("m", "f");

	public WeiboAttributesDefinition() {
		addAttribute(ID, Converters.stringConverter);
		addAttribute(USERNAME, Converters.stringConverter);
		addAttribute(WEIHAO, Converters.stringConverter);
		addAttribute(SCREEN_NAME, Converters.stringConverter);
		addAttribute(NAME, Converters.stringConverter);
		addAttribute(CREATED_AT, formattedDateConverter);
		addAttribute(GENDER, genderConverter);
		addAttribute(AVATAR, Converters.stringConverter);
		addAttribute(AVATAR_LARGE, Converters.stringConverter);
		addAttribute(AVATAR_HD, Converters.stringConverter);
		addAttribute(VERIFIED, Converters.booleanConverter);
		addAttribute(VERIFIED_TYPE, Converters.integerConverter);
		addAttribute(VERIFIED_REASON, Converters.stringConverter);
		addAttribute(PROVINCE, Converters.stringConverter);
		addAttribute(CITY, Converters.stringConverter);
		addAttribute(ADDRESS, Converters.stringConverter);
		addAttribute(LOCATION, Converters.stringConverter);
		addAttribute(DOMAIN, Converters.stringConverter);
		addAttribute(PROFILE_URL, profileUrlConverter);
		addAttribute(BLOG_URL, Converters.stringConverter);
		addAttribute(FOLLOW_ME, Converters.booleanConverter);
		addAttribute(FOLLOWERS_COUNT, Converters.integerConverter);
		addAttribute(BI_FOLLOWERS_COUNT, Converters.integerConverter);
		addAttribute(FRIENDS_COUNT, Converters.integerConverter);
		addAttribute(STATUSES_COUNT, Converters.integerConverter);
		addAttribute(FAVOURITES_COUNT, Converters.integerConverter);
		addAttribute(IS_FOLLOWING, Converters.booleanConverter);
		addAttribute(ALLOW_ALL_ACT_MSG, Converters.booleanConverter);
		addAttribute(GEO_ENABLED, Converters.booleanConverter);
		addAttribute(ALLOW_ALL_COMMENT, Converters.booleanConverter);
		addAttribute(IS_ONLINE, Converters.booleanConverter);
		addAttribute(LANG, Converters.stringConverter);
		addAttribute(REMARK, Converters.stringConverter);
		addAttribute(DESCRIPTION, Converters.stringConverter);
	}

}