package com.learn.spring.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	private Map<String,Object>beanMap=new HashMap<String,Object>();
	
	/**
	 * bean�����ĳ�ʼ��
	 * @param xml xml�����ļ�
	 */
	public void init(String xml) {
		try {
			//������ȡ�����ļ���reader����
			SAXReader reader=new SAXReader();
			//��ȡ��ǰ�߳��е���װ��������
			//ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
			//��classĿ¼�»�ȡָ����xml�ļ�
			//InputStream ins=classLoader.getResourceAsStream(xml);

			//����������Ϊʲôʹ��classloader�޷����س���·���������~~
			/*InputStream ins=Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
			Document doc=reader.read(ins);*/
			
			Document doc=reader.read(xml);
			Element root=doc.getRootElement();
			Element foo;
			//����xml�ļ��е�Bean��ʵ��
			for(Iterator i=root.elementIterator("bean");i.hasNext();) {
				System.out.println("����xml�ļ��е�Bean��ʵ��");
				foo=(Element) i.next();
				//���ÿһ��Beanʵ������ȡbean������id��class
				Attribute id=foo.attribute("id");
				Attribute cls=foo.attribute("class");
				//����Java������ƣ�ͨ��class�����ƻ�ȡClass����
				Class bean=Class.forName(cls.getText());
				//��ȡclass����Ϣ
				java.beans.BeanInfo info=java.beans.Introspector.getBeanInfo(bean);
				//��ȡ��������
				java.beans.PropertyDescriptor pd[]=info.getPropertyDescriptors();
				//����һ�����󣬲��ڽ������Ĵ�����Ϊ��������Ը�ֵ
				Object obj=bean.newInstance();
				//����bean��property����
				for(Iterator ite=foo.elementIterator("property");ite.hasNext();) {
					System.out.println("����bean��property����");
					Element foo2=(Element)ite.next();
					//��ȡproperty��name����
					Attribute name=foo2.attribute("name");
					String value=null;
					//��ȡproperty����Ԫ��value��ֵ
					for(Iterator ite1=foo2.elementIterator("value");ite1.hasNext();) {
						System.out.println("��ȡproperty����Ԫ��value��ֵ");
						Element node=(Element) ite1.next();
						value=node.getText();
						break;
					}
					//����java������Ƶ��ö����ĳ��set����������������ֵ
					for(int k=0;k<pd.length;k++) {
						System.out.println("����java������Ƶ��ö����ĳ��set����������������ֵ");
						if(pd[k].getName().equalsIgnoreCase(name.getText())){
							Method mSet=null;
							mSet=pd[k].getWriteMethod();
							mSet.invoke(obj, value);
						}
					}
				}
				//���������beanMap�У�����key����idֵ��valueΪ����
				beanMap.put(id.getText(),obj);
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	/**
	 * �õ�bean����
	 * @param beanname bean��id
	 * @return bean����
	 */
	public Object getBean(String beanName) {
		Object obj=beanMap.get(beanName);
		return obj;
	}
	
	/**
	 * ���Է���
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory=new BeanFactory();
		factory.init("src/com/learn/spring/reflect/config.xml");
		//factory.init("config.xml");
		JavaBean javaBean=(JavaBean) factory.getBean("javaBean");
		System.out.println("username="+javaBean.getUsername());
		System.out.println("password="+javaBean.getPassword());
	}
}