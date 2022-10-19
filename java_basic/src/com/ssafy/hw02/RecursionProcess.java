package com.ssafy.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecursionProcess {
	
	public static void main(String[] args) throws FileNotFoundException {
		// 같은 패키지 내에 있는 파일 읽어오기
		String path = RecursionProcess.class.getResource("").getPath()+"input2.txt";
		Scanner sc = new Scanner(new FileInputStream(path));
		
		while(sc.hasNext()) {
			
			int num = sc.nextInt();
			
			System.out.println("1부터 " + num + "까지 합 : " + makeSum(num));
		}
		
	}

	
	public static int makeSum(int a) {
		
		if(a == 1) {
			return 1;
		} else {
			return a + makeSum(a-1); // 해당 숫자를 더하면서 재귀 함수 호출
		}
			
		
		
	}
	
}
