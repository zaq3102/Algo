package com.ssafy.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HealthStudentReport extends HealthStudent {

	public static void main(String args[]) throws FileNotFoundException, NumberFormatException, ParseException {
		String path = HealthStudentReport.class.getResource("").getPath() + "input3.txt";
		Scanner sc = new Scanner(new File(path));
		Scanner sc_2 = new Scanner(System.in);
		
		System.out.println("이름    측정일	몸무게	키");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		HealthStudent[] HS = new HealthStudent[6];

		for (int i = 0; i < HS.length; i++) {
			if (sc.hasNextLine()) {
				String[] srr = sc.nextLine().split(",");
				HS[i] = new HealthStudent(srr[0], transFormat.parse(srr[1]), Double.parseDouble(srr[2]), Double.parseDouble(srr[3]));
				System.out.println(HS[i].toString());
			} else {
				break;

			}
		}
		
		System.out.println("학원생 이름을 입력하세요. >>");
		String temp = sc_2.next();
		
		double sum_height = 0;
		double sum_weight = 0;
		double cnt = 0;
		
		for (int i = 0; i < HS.length; i++) {
			if(HS[i].getName().equals(temp)) {
//				System.out.println(HS[i]);
				sum_weight += HS[i].getWeight();
				sum_height += HS[i].getHeight();
				cnt++;
			} else {
				System.out.println("해당하는 학원생이 없습니다.");
			}
		}
		
		System.out.printf("평균 몸무게 : %.3fkg, 평균 키 : %.3fcm", sum_weight/cnt, sum_height/cnt);
		
	}

}
