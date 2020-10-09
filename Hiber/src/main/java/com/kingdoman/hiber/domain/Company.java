package com.kingdoman.hiber.domain;

/**
 * @author kingdoman
 * @date 2020/9/26
 */

public class Company {
	private Integer id;
	private String name;
	private Address1 address;
	
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
	
	public Address1 getAddress() {
		return address;
	}
	
	public void setAddress(Address1 address) {
		this.address = address;
	}
}