/**
 * 
 */
package com.example.demo.mapper;

import com.example.demo.entity.User;

/**
 * @author LOL
 * 2017年2月13日下午8:38:20
 */
public interface UserDao {
	
	public User findUserInfo(String username);
	
	public void regist(User user);
}
