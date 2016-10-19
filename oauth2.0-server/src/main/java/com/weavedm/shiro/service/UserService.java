package com.weavedm.shiro.service;

import java.util.List;

import com.weavedm.shiro.model.Oauth2User;

/**
 */
public interface UserService {
	/**
	 * 创建用户
	 * 
	 * @param Oauth2User
	 */
	public Oauth2User createUser(Oauth2User User);

	public Oauth2User updateUser(Oauth2User User);

	public void deleteUser(Long UserId);

	/**
	 * 修改密码
	 * 
	 * @param Oauth2UserId
	 * @param newPassword
	 */
	public void changePassword(Long UserId, String newPassword);

	Oauth2User findOne(Long UserId);

	List<Oauth2User> findAll();

	/**
	 * 根据用户名查找用户
	 * 
	 * @param Oauth2Username
	 * @return
	 */
	public Oauth2User findByUsername(String Username);

}
