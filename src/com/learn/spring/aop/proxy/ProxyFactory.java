package com.learn.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyFactory implements InvocationHandler{
	private Object stu;
	//生成student类的代理类
	public Object createStudentProxy(Object stu) {//创建StudentBean的代理类
		this.stu=stu;
		//第一个参数时目标对象的类加载器，第二个是该类实现的接口，第三个是InvocationHandler类实例（与回调有关）
		return Proxy.newProxyInstance(stu.getClass().getClassLoader(), 
				stu.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
		StudentBean s=(StudentBean) stu;//此处是将stu强转为StudentBean类
		Object object=null;
		if(s.getName()!=null) {//符合条件就利用method的invoke方法来真正调用目标对象的方法，否则过滤掉
			object=method.invoke(stu, args);//利用proxy返回一个通过代理来创建的一个对象
		}else {
			System.out.println("名称为空，代理类已经进行拦截");//说明代理已经发生作用
		}
		return object;
	}
}
