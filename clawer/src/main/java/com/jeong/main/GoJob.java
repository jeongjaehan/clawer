package com.jeong.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoJob {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
