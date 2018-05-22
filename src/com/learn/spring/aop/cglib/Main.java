package com.learn.spring.aop.cglib;

public class Main {

	public static void main(String[] args) {
		StudentBean s1=(StudentBean)(new CGLibProxyFactory()).createStudent(new StudentBean());
		StudentBean s2=(StudentBean)(new CGLibProxyFactory()).createStudent(new StudentBean("tom"));
		s1.print();
		s2.print();
	}
}
