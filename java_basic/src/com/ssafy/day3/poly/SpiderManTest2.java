package com.ssafy.day3.poly;

import com.ssafy.day3.extend.person.Person;
import com.ssafy.day3.extend.person.SpiderMan;


public class SpiderManTest2 {
	public static void main(String[] args) {
		Person p = new Person("홍길동");
		
		if(p instanceof SpiderMan) {
			SpiderMan sman = (SpiderMan)p;
			sman.fireWeb();
			
		} else {
			System.out.println("Not SpiderMan");
		}
		
		
		System.out.println(new Object());
		
	}

}
