package com.learn.spring.aop.proxy;

/**
 * ����proxy��ʵ��aop�Ĺ����������ܽ᣺
 * ��Ŀ��������ʵ�ֽӿ�
 * �����ش����Ĵ������
 * ����дinvoke()����
 * ��������������invoke()����
 * @author ̷ΰ��
 *
 */
public class main {

	public static void main(String[] args) {
		//StudentInterface s1=new StudentBean("Tom");//����ʵ�������Ʋ�Ϊ�յ�ʱ��
		StudentInterface s1=new StudentBean();//����ʵ�����������Ϊ�յ�ʱ��
		ProxyFactory factory=new ProxyFactory();//���ô������ഴ��һ���µ�ʵ����� 
		StudentInterface s2=(StudentInterface)factory.createStudentProxy(s1);
		s2.print();
	}
}
