package com.learn.spring.hello;

public class Person {
	private IHelloMessage helloMessage;

	public IHelloMessage getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(IHelloMessage helloMessage) {
		this.helloMessage = helloMessage;
	}
	
	public String SayHello() {
		return this.helloMessage.SayHello();
	}
}
