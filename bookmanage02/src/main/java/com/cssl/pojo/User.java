package com.cssl.pojo;

import java.io.Serializable;

//实体类
public class User implements Serializable{
	Integer id;
	String name;
	String password;
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "register [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
