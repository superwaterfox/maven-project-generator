package com.waterfox.demo;

import java.util.Date;

import com.waterfox.common.BaseBean;

public class User extends BaseBean {
	private Integer id;

	private String username;

	private Date birthday;

	private String sex;

	private String address;

	private Boolean isBoy;

	public Boolean getIsBoy() {
		return isBoy;
	}

	public void setIsBoy(Boolean isBoy) {
		this.isBoy = isBoy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}

}