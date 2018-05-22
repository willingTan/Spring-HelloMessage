package com.learn.spring.reflect;

public class Car {
	private String brand;
	private String color;
	private int maxSpeed;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	//Ĭ�Ϲ��캯��
	public Car() {
		System.out.println("init car!!");
	}
	//�������Ĺ��캯��
	public Car(String brand,String color,int maxSpeed) {
		this.brand=brand;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	//�������ķ���
	public void introduce() {
		System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
	}
}
