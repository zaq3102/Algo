package com.ssafy.ws01.step3;

public class DigitTest1 {
public static void main(String[] args) {
	int cnt = 1;
	
//	for (int i = 0; i <= 5; i++) {
//		
//		for(int k = i; k < ; j++) {
//			
//		}
//		w
//		for(int j = 5 - k; j < 5; j++) {
//			System.out.print(cnt + (5*i));
//		}
//		
//		
//	}

	//별찍기
//	for (int m = 1; m < 5; m++) {
//		for (int n = 0; n < m; n++) {
//			System.out.print("*");
//		}
//		System.out.println(" ");
//	}
	
	
//	int num = 1;
//	
//	for (int i = 0; i < 5; i++) {
//		for (int j = 0; j < i; j++) {
//			System.out.print(" ");
//		}
//		
//		for (int j = 0; j < 5-i; j++) {
//			System.out.printf("%2d ", num++);
//		}
//		System.out.println();
//	}
	
	
	
	
	
	
	for(int i = 5; i > 0; i--) {
		
		for(int k = 0; k < 5-i; k++) {
			System.out.print("   ");
		}
		
		
		for(int j = i; j > 0; j--) {
			System.out.print(cnt + " ");
			cnt++;
		}
		System.out.println();
	}
}
}
