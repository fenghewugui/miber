package com.weavedm.shiro.service.impl;

import com.weavedm.shiro.biz.dao.Oauth2UserMapper;
import com.weavedm.shiro.model.Oauth2User;
import com.weavedm.shiro.model.Oauth2UserExample;
import com.weavedm.shiro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Oauth2UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 创建用户
     * @param user
     */
    public Oauth2User createUser(Oauth2User user) {
        //加密密码
    	user =   passwordHelper.encryptPassword(user);
         userMapper.insert(user);
         return user;
    }

    public Oauth2User updateUser(Oauth2User user) {
         userMapper.updateByPrimaryKey(user);
         return user;
    }

    public void deleteUser(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
    	Oauth2User user =userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKey(user);
    }

    public Oauth2User findOne(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<Oauth2User> findAll() {
        return userMapper.selectByExample(new Oauth2UserExample());
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public Oauth2User findByUsername(String username) {
    	Oauth2UserExample userExample =  new Oauth2UserExample();
    	userExample.createCriteria().andUsernameEqualTo(username);
    	List<Oauth2User>  l= userMapper.selectByExample(userExample);
    	if(null!=l&&l.size()>0){
    		return l.get(0);
    	}
    	return null;
    }


}
