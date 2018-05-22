package com.learn.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyFactory implements InvocationHandler{
	private Object stu;
	//����student��Ĵ�����
	public Object createStudentProxy(Object stu) {//����StudentBean�Ĵ�����
		this.stu=stu;
		//��һ������ʱĿ����������������ڶ����Ǹ���ʵ�ֵĽӿڣ���������InvocationHandler��ʵ������ص��йأ�
		return Proxy.newProxyInstance(stu.getClass().getClassLoader(), 
				stu.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
		StudentBean s=(StudentBean) stu;//�˴��ǽ�stuǿתΪStudentBean��
		Object object=null;
		if(s.getName()!=null) {//��������������method��invoke��������������Ŀ�����ķ�����������˵�
			object=method.invoke(stu, args);//����proxy����һ��ͨ��������������һ������
		}else {
			System.out.println("����Ϊ�գ��������Ѿ���������");//˵�������Ѿ���������
		}
		return object;
	}
}
