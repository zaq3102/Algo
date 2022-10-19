package com.ssafy.ws01.step3;

public class DigitTest2 {
	public static void main(String[] args) {
//		*****05
//		 ***13
//		  *21
//		 ***13
//		*****05
//		숫자를 만들고 그 숫자에 맞춰 별을 찍자
		int num = 1;
		
		for (int i = 0; i < 5; i++) {
			
			int space = i;
			
			if(i > 2) {
				space = 4 - i;
			}
			
			int star = -2 * space + 5;
			
			for (int j = 0; j < space; j++) {
				System.out.print("   ");
			}	
			
			for (int j = 0; j < star; j++) {
				System.out.printf("%2d ",num++);
			}
			System.out.println();
			
			
		}
		
		
	}

	
	
	
	
}
