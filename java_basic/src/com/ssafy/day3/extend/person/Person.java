package com.ssafy.day3.extend.person;

public class Person extends Object{

	String name;
	
	// 시스템이 자동으로 생성자를 만들어줄때 이런 식으로 만들어준다
	public Person(String name) {
		super(); // Object 생성자 호출
		this.name = name;
	}
	
	
	public void eat() {
		System.out.println("냠냠");
		
		
	}
	
	public void jump() {
		
		System.out.println("폴짝");
		
		
	}
	
	
	
}
