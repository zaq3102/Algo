package com.ssafy.io;

import java.util.Scanner;

public class R1_FactorialTest {
	public static int factorial(int n) {
		
		int res = 1;
		for (int i = n; i > 0; i--) { // 반복처리
			res *= i; // 반복단위
		}
		return res;
	}
	
	// 리턴값 활용하지 않음 : 위 반복문을 재귀로 변경
	
	static int res = 1;
	public static void factorial2(int n) {
		
		// 기본 파트
		if(n <= 0) return;

		// 유도 파트
		res *= n;
		factorial2(n-1);
	}
	
	// 리턴값 활용 : n! = n * n-1!
	
	public static int factorial3(int n) {
		
		if(n == 1) return 1; // 기본 파트
		
		return n * factorial3(n-1); // 유도 파트
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(factorial(n));
		factorial2(n);
		System.out.println(res);
		System.out.println(factorial3(n));
	}
}
