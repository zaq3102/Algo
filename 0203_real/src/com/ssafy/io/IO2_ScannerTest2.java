package com.ssafy.io;

import java.util.Scanner;

public class IO2_ScannerTest2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 기?");
		System.out.println("==> SSAFY " + sc.nextInt() + "기");
		
		// 개행문자를 한 번 흘리기 위한 조치! = 정수 입력 후 엔터(개행문자)를 입력하면 한마디를 입력할 수 없으므로 해당 문장을 통해 개행문자를 한 번 날린다.
		sc.nextLine(); 
		
		System.out.print("우리 기수를 나타내는 한마디?");
		System.out.println("==>" + sc.nextLine());
		//nextLine 메서드는 공백구분자를 읽어들이지 않는다 => "7 hi" 입력시 "7", " hi" 처럼 공백문자가 들어감
		//
	}
}
