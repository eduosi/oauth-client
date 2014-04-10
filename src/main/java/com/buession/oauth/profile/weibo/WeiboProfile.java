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

import java.util.Date;

import org.scribe.up.profile.AttributesDefinition;

import com.buession.oauth.profile.BaseOAuthProfile;
import com.buession.oauth.profile.OAuthAttributesDefinitions;
import com.buession.open.utils.Gender;

/**
 * Sina Weibo OAuth profile
 * 
 * @author Yong.Teng <webmaster@buession.com>
 */
public class WeiboProfile extends BaseOAuthProfile {

	private static final long serialVersionUID = -3526611200283762984L;

	@Override
	public String getUsername() {
		return getScreenName();
	}

	/**
	 * 返回用户微号
	 * 
	 * @return 用户微号
	 */
	public Object getWeiHao() {
		return get(WeiboAttributesDefinition.WEIHAO);
	}

	/**
	 * 返回用户昵称
	 * 
	 * @return 用户昵称
	 */
	public String getScreenName() {
		return (String) get(WeiboAttributesDefinition.SCREEN_NAME);
	}

	/**
	 * 返回用户友好显示名称
	 * 
	 * @return 用户友好显示名称
	 */
	@Override
	public String getRealName() {
		return (String) get(WeiboAttributesDefinition.NAME);
	}

	/**
	 * 返回用户用户创建（注册）时间
	 * 
	 * @return 用户用户创建（注册）时间
	 */
	public Date getCreatedAt() {
		return (Date) get(WeiboAttributesDefinition.CREATED_AT);
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
	 * 返回用户大小 180×180 像素头像地址（大图）
	 * 
	 * @return 用户大小 180×180 像素头像地址（大图）
	 */
	public String getAvatarLarge() {
		return (String) get(WeiboAttributesDefinition.AVATAR_LARGE);
	}

	/**
	 * 返回用户高清头像原图地址
	 * 
	 * @return 用户高清头像原图地址
	 */
	public String getAvatarHd() {
		return (String) get(WeiboAttributesDefinition.AVATAR_HD);
	}

	/**
	 * 返回用户头像地址
	 * 
	 * @return 用户头像地址
	 */
	@Override
	public String getAvatar() {
		String avatarHd = getAvatarHd();
		return avatarHd != null && avatarHd.length() > 0 ? avatarHd : getAvatarLarge();
	}

	/**
	 * 返回用户是否是微博认证用户
	 * 
	 * @return 是否是微博认证用户
	 */
	public boolean getIsVerified() {
		return (Boolean) get(WeiboAttributesDefinition.VERIFIED);
	}

	/**
	 * Return the verified type of the user.
	 * 
	 * @return the verified type of the user
	 */
	@Deprecated
	public String getVerifiedType() {
		return (String) get(WeiboAttributesDefinition.VERIFIED_TYPE);
	}

	/**
	 * 返回用户认证原因
	 * 
	 * @return 认证原因
	 */
	public String getVerifiedReason() {
		return (String) get(WeiboAttributesDefinition.VERIFIED_REASON);
	}

	/**
	 * 返回用户个性化域名
	 * 
	 * @return 用户个性化域名
	 */
	public String getDomain() {
		return (String) get(WeiboAttributesDefinition.DOMAIN);
	}

	/**
	 * 返回用户个人资料页地址
	 * 
	 * @return 用户个人资料页地址
	 */
	@Override
	public String getProfileUrl() {
		return (String) get(WeiboAttributesDefinition.PROFILE_URL);
	}

	/**
	 * 返回用户博客地址
	 * 
	 * @return 用户博客地址
	 */
	public String getBlogUrl() {
		return (String) get(WeiboAttributesDefinition.BLOG_URL);
	}

	/**
	 * 返回用户所在省级 ID
	 * 
	 * @return 用户所在省级 ID
	 */
	@Override
	public String getProvince() {
		return (String) get(WeiboAttributesDefinition.PROVINCE);
	}

	/**
	 * 返回用户所在城市 ID
	 * 
	 * @return 返回用户所在城市 ID
	 */
	@Override
	public String getCity() {
		return (String) get(WeiboAttributesDefinition.CITY);
	}

	/**
	 * 返回用户所在地
	 * 
	 * @return 返回用户所在地
	 */
	@Override
	public String getAddress() {
		return (String) get(WeiboAttributesDefinition.LOCATION);
	}

	/**
	 * 返回用户是否是微博 VIP 用户（即认证用户）
	 * 
	 * @return 是否是微博 VIP 用户（即认证用户）
	 */
	@Override
	public boolean getIsVip() {
		return getIsVerified();
	}

	/**
	 * 返回用户是否关注当前登录用户
	 * 
	 * @return 是否是否关注当前登录用户
	 */
	public boolean getIsFollowedMe() {
		return (Boolean) get(WeiboAttributesDefinition.FOLLOW_ME);
	}

	/**
	 * 返回用户粉丝数
	 * 
	 * @return 用户粉丝数
	 */
	public int getFollowersCount() {
		return (Integer) get(WeiboAttributesDefinition.FOLLOWERS_COUNT);
	}

	/**
	 * 返回用户互粉数
	 * 
	 * @return 用户互粉数
	 */
	public int getBiFollowersCount() {
		return (Integer) get(WeiboAttributesDefinition.BI_FOLLOWERS_COUNT);
	}

	/**
	 * 返回用户关注数
	 * 
	 * @return 用户关注数
	 */
	public int getFriendsCount() {
		return (Integer) get(WeiboAttributesDefinition.FRIENDS_COUNT);
	}

	/**
	 * 返回用户微博数
	 * 
	 * @return 用户微博数
	 */
	public int getStatusesCount() {
		return (Integer) get(WeiboAttributesDefinition.STATUSES_COUNT);
	}

	/**
	 * 返回用户收藏数
	 * 
	 * @return 用户收藏数
	 */
	public int getFavouritesCount() {
		return (Integer) get(WeiboAttributesDefinition.FAVOURITES_COUNT);
	}

	/**
	 * Return is or not following for the user.
	 * 
	 * @return is or not following me for the user
	 */
	@Deprecated
	public boolean getIsFollowing() {
		return (Boolean) get(WeiboAttributesDefinition.IS_FOLLOWING);
	}

	/**
	 * 返回是否允许所有人给我发私信
	 * 
	 * @return 是否允许所有人给我发私信
	 */
	public boolean getIsAllowAllActMsg() {
		return (Boolean) get(WeiboAttributesDefinition.ALLOW_ALL_ACT_MSG);
	}

	/**
	 * 返回是否允许标识用户的地理位置
	 * 
	 * @return 是否允许标识用户的地理位置
	 */
	public boolean getIsGeoEnabled() {
		return (Boolean) get(WeiboAttributesDefinition.GEO_ENABLED);
	}

	/**
	 * 返回是否允许所有人对我的微博进行评论
	 * 
	 * @return 是否允许所有人对我的微博进行评论
	 */
	public boolean getIsAllowAllComment() {
		return (Boolean) get(WeiboAttributesDefinition.ALLOW_ALL_COMMENT);
	}

	/**
	 * 返回用户是否在线
	 * 
	 * @return 是否用户是否在线
	 */
	public boolean getIsOnline() {
		return (Boolean) get(WeiboAttributesDefinition.IS_ONLINE);
	}

	/**
	 * 返回用户当前的语言版本
	 * 
	 * @return 用户当前的语言版本
	 */
	public String getLang() {
		return (String) get(WeiboAttributesDefinition.LANG);
	}

	/**
	 * 返回用户备注信息，只有在查询用户关系时才返回此字段
	 * 
	 * @return 用户备注信息
	 */
	public String getRemark() {
		return (String) get(WeiboAttributesDefinition.REMARK);
	}

	/**
	 * 返回用户个人描述
	 * 
	 * @return 用户个人描述
	 */
	public String getDescription() {
		return (String) get(WeiboAttributesDefinition.DESCRIPTION);
	}

	/**
	 * 返回用户资料属性属性定义
	 * 
	 * @return 用户资料属性属性定义
	 */
	@Override
	protected AttributesDefinition getAttributesDefinition() {
		return OAuthAttributesDefinitions.weiboDefinition;
	}

}