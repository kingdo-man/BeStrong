package com.kingdoman.bestrong.spring.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author kingdoman
 * @date 2020/10/9
 */

public class Student {

	private String name;
	private String password;
	private Integer age;
	private List<String> courseList;
	private Set<String> cars;
	private Map<String, String> infos;

	public Student() {
	}

	public Student(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("2赋值name：" + name);
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("2赋值password：" + password);
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}

	public Set<String> getCars() {
		return cars;
	}

	public void setCars(Set<String> cars) {
		this.cars = cars;
	}

	public Map<String, String> getInfos() {
		return infos;
	}

	public void setInfos(Map<String, String> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", courseList=" + courseList +
				", cars=" + cars +
				", infos=" + infos +
				'}';
	}
}
