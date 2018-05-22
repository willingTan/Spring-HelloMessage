package com.learn.spring.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxyFactory implements MethodInterceptor{
	private Object object;
	public Object createStudent(Object object) {
		this.object=object;
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Object intercept(Object proxy,Method method,Object[] args,
			MethodProxy methodProxy) throws Throwable{
		StudentBean stu=(StudentBean)object;
		Object result=null;
		if(stu.getName()!=null) {
			result=methodProxy.invoke(object, args);
		}else {
			System.out.println("该方法已经被拦截！！！");
		}
		return result;
	}
}
