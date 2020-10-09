package com.kingdoman.hiber.domain;

/**
 * @author kingdoman
 * @date 2020/9/26
 */

public class Company1 {
	private Integer id;
	private String name;
	private Address address;
	
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}