package com.ssafy.hw02;

public class ArrayProcessBmi {

	public static void main(String[] args) {
		double [][] arr = {
				{21, 53.2, 1.673},
				{35, 90.3, 1.781},
				{28, 70.7, 1.653},
				{25, 75.1, 1.811},
				{31, 62.0, 1.532}
		};
		
		
		double age = 0;		
		double weight = 0;
		double height = 0;
		
		System.out.println("idx\t만 나이\t몸무게(kg)\t키(m)");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("학원생%d\t%.1f\t%.1f\t%.3f\n", (i+1), arr[i][0],arr[i][1],arr[i][2]);
			
			age += arr[i][0];
			weight += arr[i][1];
			height += arr[i][2];
			
		}
		System.out.printf("평균\t%.3f\t%.3f\t%.3f\n", age/arr.length,weight/arr.length, height/arr.length);
	}
}
