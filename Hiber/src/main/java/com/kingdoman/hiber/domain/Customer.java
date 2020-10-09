package com.kingdoman.hiber.domain;

import java.util.Set;

/**
 * @author kingdoman
 * @date 2020/9/28
 */

public class Customer {
	
	private Integer id;
	private String name;
	private Set<Order> orders;
	
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
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
