package com.learn.spring.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	//�����initByDefaultConst�����ڻ�ȡĬ�Ϲ���������ȡCar�����
	public static Car initByDefaultConst() throws Throwable{
		//ͨ����װ�ػ��Car�����
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class clazz=loader.loadClass("com.learn.spring.reflect.Car");
		//��ȡ��Ĭ�Ϲ���������ʵ����Car
		Constructor cons=clazz.getDeclaredConstructor((Class[])null);
		Car car=(Car)cons.newInstance();
		//�������䷽����������
		Method setBrand=clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "����");
		Method setColor=clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "��ɫ");
		Method setMaxSpeed=clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 200);
		return car;
	}
	//�����initByParamConst�����ڻ�ȡĬ�Ϲ���������ȡCar�����
	public static Car initByParamConst() throws Throwable{
		//ͨ����װ�ػ��Car�����
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class clazz=loader.loadClass("com.learn.spring.reflect.Car");
		//��ȡ���д��в����Ĺ���������
		Constructor cons=clazz.getDeclaredConstructor(new Class[] {String.class,String.class,int.class});
		//ʹ�����Ĺ�����ʵ����Car
		Car car=(Car)cons.newInstance(new Object[] {"����","��ɫ",180});
		return car;
	}
	
	public static void main(String[] args) throws Throwable{
		Car car1=initByDefaultConst();
		Car car2=initByParamConst();
		car1.introduce();
		car2.introduce();
	}
}
