package com.ssafy.day3.poly;


import com.ssafy.day3.extend.person.Person;
import com.ssafy.day3.extend.person.SpiderMan;

public class SpiderManPolyTest {
	public static void main(String[] args) {
		// 하나의 객체를 ...
		SpiderMan onlyOne = new SpiderMan();
		
		// 여러 가지 타입으로 참조한다 => 다형성!
		Person person = onlyOne;
		Object obj = onlyOne;
		
		obj.toString();
		
		SpiderMan sman2 = (SpiderMan)obj;
		sman2.fireWeb();
		
		Object [] objs = new Object[5];
		objs[0] = onlyOne;
		objs[1] = new Object();
		objs[2] = "Hello";
		objs[3] = 4; // autoBoxing
		objs[4] = true;
		
		
		
	}
}
