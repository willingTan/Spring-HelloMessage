package com.learn.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 定义切面类
 */
@Aspect
public class StuInterceptor {
	/*
	 * 打印方法AOP
	 * 注意不要把单词写错了，不然凉了呀~~是execution而不是excution
	 */
	@Pointcut("execution(* com.learn.spring.aop.aspect.Student.print(..))")
	//@Pointcut("execution(* com.learn.spring.aop.aspect.Student.*(..))")
	public void printMethod() {}
	
	@Before("printMethod()")
	public void  printBeforeAdvice() {
		System.out.println("printBeforeAdvice()!");
	}
	
	@AfterReturning(pointcut="printMethod()",returning="flag")
	public void printAfterAdvice(String flag) {
		System.out.println("printAfterAdvice()!  "+flag);
	}
	
	@After("printMethod()")
	public void finallyAdvice() {
		System.out.println("finallyAdvice()!");
	}
	
	@Around("printMethod() && args(name)")
	public Object printAroundAdvice(ProceedingJoinPoint pjp,String name) throws Throwable{
		Object result=null;
		if(name.equals("twl")) pjp.proceed();
		else System.out.println("print()方法已经被拦截！！！");
		return result;
	}
}