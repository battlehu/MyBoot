/**
 * 
 */
package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author LOL
 * 2017年2月13日下午8:42:25
 */

@Component
@Lazy
public class User {
	private int id;
	private String username;
	private String password;
	private String realname;
	private String sex;
	public User() {
		super();
	}
	public User(String username, String password, String realname, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
	}
	public User(int id, String username, String password, String realname, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", sex=" + sex + "]";
	}
}
