package com.learn.spring.aop.proxy;

/**
 * 利用proxy来实现aop的功能有如下总结：
 * ·目标对象必须实现接口
 * ·返回创建的代理对象
 * ·重写invoke()方法
 * ·限制条件放在invoke()方法
 * @author 谭伟林
 *
 */
public class main {

	public static void main(String[] args) {
		//StudentInterface s1=new StudentBean("Tom");//测试实体类名称不为空的时候
		StudentInterface s1=new StudentBean();//测试实体类对象名称为空的时候
		ProxyFactory factory=new ProxyFactory();//利用代理工厂类创建一个新的实体对象 
		StudentInterface s2=(StudentInterface)factory.createStudentProxy(s1);
		s2.print();
	}
}
