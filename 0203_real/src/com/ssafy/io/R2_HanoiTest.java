package com.ssafy.io;

public class R2_HanoiTest {
	public static void main(String[] args) {
		
		hanoi(3,1,2,3);
		
		
	}
	
	public static void hanoi(int n, int from, int temp, int to) {
		
		if(n == 0) return;
		
		
		
		
		//여기부터 기저 파트
		// n-1개(덩어리) 원판 이동
		hanoi(n-1, from, to, temp);
		
		// n번 원판 이동
		System.out.println(n + " : " + from + "->" + to);
		
		// n-1개(덩어리) 원판 이동
		hanoi(n-1, temp, from, to);
		
		
	}
	
	
}
