package com.kingdoman.hiber.domain;

import java.util.Set;

/**
 * @author kingdoman
 * @date 2020/9/28
 */

public class Student {
	
	private Integer sid;
	private String name;
	private Set<Course> Courses;
	
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Course> getCourses() {
		return Courses;
	}
	
	public void setCourses(Set<Course> courses) {
		Courses = courses;
	}
}
