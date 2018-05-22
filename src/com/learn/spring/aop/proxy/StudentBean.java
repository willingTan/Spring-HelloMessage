package com.learn.spring.aop.proxy;

public class StudentBean implements StudentInterface{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentBean() {}
	public StudentBean(String name) {
		this.name=name;
	}
	public void print() {
		System.out.println("Hello World");
	}
}
