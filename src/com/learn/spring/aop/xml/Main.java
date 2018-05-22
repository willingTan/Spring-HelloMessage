package com.learn.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//首先创建spring容器
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("conf/conf-aspect.xml");
		ApplicationContext ctx=new  FileSystemXmlApplicationContext("conf/conf-xml.xml");
		Student stu=(Student)ctx.getBean("stu");
		stu.print("twl");
	}
}
