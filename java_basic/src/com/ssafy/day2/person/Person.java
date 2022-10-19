package com.ssafy.day2.person;

public class Person {
	
	// 멤버 변수 - 속성
	String name;
	int age;
	boolean isHungry;
	
	static String scientificName = "호모사피엔스";
	
	void eat() {
		isHungry = false;
		System.out.println("먹기");
	}

	void work() {
		isHungry = true;
		System.out.println("일하기");
	}
	
	void printInfo() {
		System.out.println("못봤다");
	}


}
