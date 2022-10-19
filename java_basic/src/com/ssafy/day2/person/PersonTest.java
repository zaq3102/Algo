package com.ssafy.day2.person;

public class PersonTest {

	public static void main(String[] args) {
		// 객체 생성과 무관하게 메모리에 올라가 있음
		System.out.println(Person.scientificName);
		
		int i = 10;
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 10;
		p1.eat();
		
		Person p2 = new Person();
		p2.age = 3;
		p2.name = "장길산";
		p2.work();
		
		// 모든 객체가 영향을 받는다
		System.out.println(p2.scientificName);
		
		p1.printInfo();
		p2.printInfo();
		
	}

}
