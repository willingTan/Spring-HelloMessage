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
	 * bean工厂的初始化
	 * @param xml xml配置文件
	 */
	public void init(String xml) {
		try {
			//创建读取配置文件的reader对象
			SAXReader reader=new SAXReader();
			//获取当前线程中的类装载器对象
			//ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
			//从class目录下获取指定的xml文件
			//InputStream ins=classLoader.getResourceAsStream(xml);

			//不明白这里为什么使用classloader无法加载出类路径，很奇怪~~
			/*InputStream ins=Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
			Document doc=reader.read(ins);*/
			
			Document doc=reader.read(xml);
			Element root=doc.getRootElement();
			Element foo;
			//遍历xml文件中的Bean的实例
			for(Iterator i=root.elementIterator("bean");i.hasNext();) {
				System.out.println("遍历xml文件中的Bean的实例");
				foo=(Element) i.next();
				//针对每一个Bean实例，获取bean的属性id和class
				Attribute id=foo.attribute("id");
				Attribute cls=foo.attribute("class");
				//利用Java反射机制，通过class的名称获取Class对象
				Class bean=Class.forName(cls.getText());
				//获取class的信息
				java.beans.BeanInfo info=java.beans.Introspector.getBeanInfo(bean);
				//获取属性描述
				java.beans.PropertyDescriptor pd[]=info.getPropertyDescriptors();
				//创建一个对象，并在接下来的代码中为对象的属性赋值
				Object obj=bean.newInstance();
				//遍历bean的property属性
				for(Iterator ite=foo.elementIterator("property");ite.hasNext();) {
					System.out.println("遍历bean的property属性");
					Element foo2=(Element)ite.next();
					//获取property的name属性
					Attribute name=foo2.attribute("name");
					String value=null;
					//获取property的子元素value的值
					for(Iterator ite1=foo2.elementIterator("value");ite1.hasNext();) {
						System.out.println("获取property的子元素value的值");
						Element node=(Element) ite1.next();
						value=node.getText();
						break;
					}
					//利用java反射机制调用对象的某个set方法，并将其设置值
					for(int k=0;k<pd.length;k++) {
						System.out.println("利用java反射机制调用对象的某个set方法，并将其设置值");
						if(pd[k].getName().equalsIgnoreCase(name.getText())){
							Method mSet=null;
							mSet=pd[k].getWriteMethod();
							mSet.invoke(obj, value);
						}
					}
				}
				//将对象放入beanMap中，其中key就是id值，value为对象
				beanMap.put(id.getText(),obj);
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	/**
	 * 得到bean对象
	 * @param beanname bean的id
	 * @return bean对象
	 */
	public Object getBean(String beanName) {
		Object obj=beanMap.get(beanName);
		return obj;
	}
	
	/**
	 * 测试方法
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