package com.kingdoman.hiber.domain;

import java.util.Set;

/**
 * @author kingdoman
 * @date 2020/9/28
 */

public class Course {
	
	private Integer cid;
	private String name;
	private Set<Student> students;
	
	public Integer getCid() {
		return cid;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
