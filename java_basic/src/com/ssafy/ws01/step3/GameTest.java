package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		int total = 0; //총판수
		
ex:		while(true) {
			System.out.println("가위바위보 게임을 시작합니다.");
			System.out.println("아래 보기 중 하나를 고르세요");
			System.out.println("1. 5판3승");
			System.out.println("2. 3판2승");
			System.out.println("3. 1판1승");
			System.out.print("번호를 입력하세요.");
			int menu = sc.nextInt();
					
			switch (menu) {
			case 1:
				total = 5;
				break ex;
			case 2:
				total = 3;
				break ex;
			case 3:
				total = 1;
				break ex;
				
			default:
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				System.out.println("다시 입력하세요.");
			}
				
		}
		
		int win = 0;
		int lose = 0;
		int draw = 0;		
		
		
		for (int i = 0; i < total; i++) {
			int v = (int)(Math.random()*3) +1; // 1 사용자승 2무승부 3사용자패
			System.out.print("가위바위보 중 하나 입력:");
			
			sc.next();
			switch (v) {
			case 1:
				win++;
				System.out.println("이겼습니다!!!");
				break;
			case 2:
				draw++;
				System.out.println("비겼습니다!!");
				break;
			case 3:
				lose++;
				System.out.println("졌습니다.");
				break;

			}	
			
		}
		
		if(win > lose) {
			System.out.println("###사용자 승!!!");
		} else if(win == lose) {
			System.out.println("###무승부!!");
		} else {
			System.out.println("###컴퓨터 승!!!");
			
		}
		
	}

}
