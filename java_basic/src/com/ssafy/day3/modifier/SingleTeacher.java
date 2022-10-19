package com.ssafy.day3.modifier;

public class SingleTeacher {
	
	private static SingleTeacher st = new SingleTeacher();
	
	public static SingleTeacher getTeacher() {
		return st;
	}
	
	private SingleTeacher() {
		// TODO Auto-generated constructor stub
	}
	
	void teach () {
		System.out.println("Single Teacher");
		
	}

}
