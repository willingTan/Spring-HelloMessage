package com.learn.spring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class StuInterceptor {
	public void printMethod() {}
	
	public void  printBeforeAdvice() {
		System.out.println("printBeforeAdvice()!");
	}
	
	public void printAfterAdvice(String flag) {
		System.out.println("printAfterAdvice()!  "+flag);
	}
	
	public void finallyAdvice() {
		System.out.println("finallyAdvice()!");
	}
	
	public Object printAroundAdvice(ProceedingJoinPoint pjp,String name) throws Throwable{
		Object result=null;
		if(name.equals("twl")) pjp.proceed();
		else System.out.println("print()方法已经被拦截！！！");
		return result;
	}
}
