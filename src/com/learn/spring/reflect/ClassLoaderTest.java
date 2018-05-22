package com.learn.spring.reflect;

public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		//打印类装载器信息
		System.out.println("current loader:"+loader);
		//打印类装载器父类装载器的信息
		System.out.println("parent loader:"+loader.getParent());
		//打印类装载器祖父类装载器的信息
		System.out.println("grandparent loader:"+loader.getParent().getParent());
		//由于根装载器无法被访问到，所以就会得到null值
	}
}
