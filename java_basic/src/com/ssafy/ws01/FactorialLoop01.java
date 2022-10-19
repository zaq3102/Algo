package com.ssafy.ws01;

import java.util.Scanner;

/**
 * 팩토리얼 구하기
 * @author 조효은
 * @since 2022.01.17
 */
public class FactorialLoop01 {

	public static void main(String[] args) {
	
		Scanner scann=new Scanner(System.in);
		System.out.println("INSERT NUMBER PLZ");
		int n=scann.nextInt();
		int first = n;
		int result = 1;
		
		
		
		while(n > 0) {
			result *= n;
			n--;
		}

		System.out.printf("%d!=%d",first,result);
		
	}

}
