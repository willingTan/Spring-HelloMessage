package com.learn.spring.aop.aspect;
/*
 * 定义实体类
 */
public class Student {
	public String print(String name) {
		System.out.println(name);
		return "Hello World";
	}
}
