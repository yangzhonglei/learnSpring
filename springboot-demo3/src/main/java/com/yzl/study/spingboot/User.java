package com.yzl.study.spingboot;



public class User {

	
	private String name ;
	private Integer age ;
	private String addr ;
	private String email ;
	public User(String name, Integer age, String addr, String email) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
