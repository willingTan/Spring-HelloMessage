package com.learn.spring.reflect;

public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		//��ӡ��װ������Ϣ
		System.out.println("current loader:"+loader);
		//��ӡ��װ��������װ��������Ϣ
		System.out.println("parent loader:"+loader.getParent());
		//��ӡ��װ�����游��װ��������Ϣ
		System.out.println("grandparent loader:"+loader.getParent().getParent());
		//���ڸ�װ�����޷������ʵ������Ծͻ�õ�nullֵ
	}
}
