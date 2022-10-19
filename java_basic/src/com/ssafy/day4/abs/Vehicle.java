package com.ssafy.day4.abs;

abstract class Vehicle { // 추상 메서드 사용을 위한 추상 클래스 선언
	private int curX, curY;

	public void reportPosition() {
		System.out.printf("현재 위치: (%d, %d)%n", curX, curY);
	}

	public abstract void addFuel(); // 추상 메서드 => 구현부 생략
}
