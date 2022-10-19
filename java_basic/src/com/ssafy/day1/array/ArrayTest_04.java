package com.ssafy.day1.array;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class ArrayTest_04 {
	public static void main(String[] args) {

		String org = "SSAFY";
		// TODO: char []을 이용해 String org의 각 문자를 저장하고 출력하는 코드를 작성하시오.
		// END:
		
		char [] arr_char = new char[org.length()];
		
		
		for (int i = 0; i < arr_char.length; i++) {
			arr_char[i] = org.charAt(i);
		}
		for (int i = 0; i < arr_char.length; i++) {
			System.out.println(arr_char[i]);
		}
		
	}
}
