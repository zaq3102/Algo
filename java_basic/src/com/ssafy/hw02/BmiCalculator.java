package com.ssafy.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BmiCalculator {
public static void main(String[] args) throws FileNotFoundException {
	//파일에서 읽어오기
	Scanner sc = new Scanner(new File("C:\\SSAFY\\01_java\\java_basic\\src\\hw02\\input.txt"));
	
//	String path = BmiCalculator.class.getResource("").getPath()+input.txt; 상대경로 가저오기
//	Scanner sc = new Scanner(new FileInputStream(path)); 같은 패키지 내에 있는 파일 읽어오기
	
	
//	1. 한줄을 통째로 읽어오기
//	String line = sc.nextLine();
	
//	2. 구분자로 나누기
//	String[] srr = line.split(","); //문자열 의 배열로 리턴
	
//	3. 문자열 -> 숫자 변환
//	int a = Integer.valueOf(srr[0]);
	double [] bmi = new double[10];
	
	for (int i = 0; i < bmi.length; i++) {
		
		if(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] srr = line.split(",");
			
//			위 두 문장을 하나로 합치면 => String[] srr = sc.nextLine().split(",");
			
//			기본형	Wrapper Class
//			byte	Byte
//			short	Short
//			int		"Integer"
//			long	Long
//			float	Float
//			double	Double
//			boolean	Boolean
//			char	"Character"
			
			int age = Integer.valueOf(srr[0]); // 문자열 -> int 변환
			double weight = Double.valueOf(srr[1]);
			double height = Double.valueOf(srr[2]);
//			Double.parseDouble("3.14);  위의 메서드랑 똑같은 효과
		
			
			bmi[i] = weight / ((height / 100.0) * (height / 100.0));

		} else {
//			System.out.println("Empty Line!");
			break;
			
		}
		
	}
	
//	이렇게 해도 되지만 아예 WHILE문에서 입력 출력을 한 번에 처리해도 됨
	for (int j = 0; j < bmi.length; j++) {
		if(bmi[j]==0.0) {
//			System.out.println("BMI IS DONE!");
			break;
		}
		
		if(bmi[j] > 30.0) {
			System.out.println("BMI 지수는 " + bmi[j] + "로 <고도비만>입니다.");
			
		} else if(bmi[j] > 25.0) {
			System.out.println("BMI 지수는 " + bmi[j] + "로 <비만>입니다.");
		} else if(bmi[j] > 23.0) {
			System.out.println("BMI 지수는 " + bmi[j] + "로 <과체중>입니다.");
		} else if(bmi[j] > 18.5) {
			System.out.println("BMI 지수는 " + bmi[j] + "로 <정상>입니다.");
		} else {
			System.out.println("BMI 지수는 " + bmi[j] + "로 <저체중>입니다.");
		}
		
		
	}
	
	
	
	
}
}
