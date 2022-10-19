package com.ssafy.day5.exception;

/**
 * @since 2021. 7. 7.
 */
public class SimpleException {
	public static void main(String[] args) {
		int[] intArray = { 10 };
		try {
			System.out.println(intArray[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("프로그램 종료합니다.");
	}
}
