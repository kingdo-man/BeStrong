package com.kingdoman.hiber.domain;

/**
 * @author kingdoman
 * @date 2020/10/7
 */

public class Address1 {
	private Integer id;
	private String name;
	private Company1 company;
	
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
	
	public Company1 getCompany() {
		return company;
	}
	
	public void setCompany(Company1 company) {
		this.company = company;
	}
}
