package com.ssafy.ws02.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// 같은 패키지 내에 있는 파일 읽어오기
		String path = Solution.class.getResource("").getPath()+"input.txt";
		Scanner sc = new Scanner(new FileInputStream(path));
		
		int TC = sc.nextInt();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // 3~20
			char[][] map = new char[N+2][N+2]; // 배열을 한꺼풀 테두리 두른다
			
			for (int i = 1; i <= N; i++) { //map배열 생성
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			int[] dr = {-1,-1,-1,0,1,1,1,0}; // 좌상 상 우상 우 우하 하 좌하 좌
			int[] dc = {-1,0,1,1,1,0,-1,-1};
			
			int maxHeight = 0;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(map[r][c] == 'G') continue;
					// 인접한 칸에 G가 있는지 체크
					boolean flag = true;
					int height = 0; //초기값
					
					for (int k = 0; k < dc.length; k++) {
						if(map[r + dr[k]][c + dc[k]] == 'G') {
							height = 2; // G가 있으면 2층
							flag = false;
							break;
						}
					}
					
					if(flag) { // 빌딩을 높게 세울 수 있음
						//r,c 가로줄 세로줄의 B 개수 카운팅
						for (int i = 1; i <= N; i++) {
							if(map[r][i] == 'B') height++;
							if(map[i][c] == 'B') height++;
							
							
						}
						height--; //r,c를 두 번 카운팅해서 보정
						
					}
					if(maxHeight < height) {
						maxHeight = height;
					}
					
					
				}
			}
			
			
			
			
			System.out.println("#" + testCase + " " + maxHeight);
		} // end of for testCase
		
		

		
		
//		swap
//		int x = 1;
//		int y = 2;
//		int temp = x;
//		x = y;
//		y = temp;
		
		
//		1~10까지 합
//		int sum = 0; //연산자에 대한 항등원으로 초기화
//		for (int i = 0; i < 10; i++) {
//			sum += i;
//		}
		
//		배열 원소의 합
//		int[] arr = {3,2,1,6,5,7};
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
		
//		배열에 key값이 존재/없음
//		int[] arr = {3,2,1,6,5,7};
//		int key = 6;
//		boolean flag = false; // 존재X
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] == 6) {
//				System.out.println("존재");
//				flag = true;
//				break;
//			}
//		}
//		if(!flag) {
//			System.out.println("없음");
//		}
		
//		각 숫자의 개수 출력
//		int[] arr = {3,2,1,1,2,3,1,1,2,2,0,0};
//		int[] cnt = new int[arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			cnt[arr[i]]++;
//		}
		
//		최대값, 최소값
//		int[] arr = {3,2,1,6,5,7};
//		int max = 0; // 최대값을 저장해둘 변수, 초기값 중요
		// 1. 이 세상에 존재하는 가장 작은 값 int max = Integer.MIN_VALUE;
		// 2. 원소 중 하나의 값
		
		
//------------------------------------------------------------------
		
		
//		char[][] Mat = {{'G', 'B', 'B'}, {'B', 'B', 'B'},{'B', 'G', 'B'}};
//		int[][] Mat_result = {{},{},{}};
//		
//		
//		for (int i = 0; i < Mat[0].length; i++) {
//			
//			for (int j = 0; j < Mat.length; j++) {
//				
//				if(Mat[i][j] == 'G') {
//					continue;
//				} else {
//					
//					if(i == 0 && j == 0) {
//						
//						
//					}
//					
//					if(i == Mat[0].length-1) {
//						
//					}
//					
//					
//					if(i == 0) {
//						
//						
//					}
//					
//					if(j == Mat.length-1) {
//						
//					}
//					
//					
//					if(j == 0) {
//						
//						
//					}				
//					
//					if(i == Mat[0].length-1 && j == Mat.length-1) {
//						
//					}
//					
//				}
//			}
//		}
		
		
	}
}
