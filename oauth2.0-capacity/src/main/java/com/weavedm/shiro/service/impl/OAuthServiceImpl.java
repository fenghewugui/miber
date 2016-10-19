package com.weavedm.shiro.service.impl;

import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weavedm.shiro.cache.RedisCacheManager;
import com.weavedm.shiro.service.OAuthService;

/**
 */
@Service
public class OAuthServiceImpl implements OAuthService {

    private Cache cache;


    @Autowired
    public OAuthServiceImpl(RedisCacheManager cacheManager) {
        this.cache =cacheManager.getCache("code-cache");
    }

    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }

    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }

    public String getUsernameByAuthCode(String authCode) {
        return (String)cache.get(authCode);
    }

    public String getUsernameByAccessToken(String accessToken) {
        return (String)cache.get(accessToken);
    }

    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }

    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }


    public long getExpireIn() {
        return 3600L;
    }
}
