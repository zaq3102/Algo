package com.ssafy.pcs;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[], totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 던진 주사위 횟수
		numbers = new int[N]; // 차례대로 던져진 주사위 눈의 수

		int M = sc.nextInt(); // 던지기 모드(1-4)
		switch (M) {
		case 1: // 주사위 던지기 1 : 중복 순열
			dice1(0);
			break;
		case 2: // 주사위 던지기 2 : 순열
			dice2(0, new boolean[7]);
			break;
		case 3: // 주사위 던지기 3 : 중복조합
			dice3(0, 1);
			break;
		case 4: // 주사위 던지기 4 : 조합
			dice4(0, 1);
			break;

		default:
			break;
		}
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	public static void dice1(int cnt) { // 주사위 던지기 1 : 중복 순열

		if (cnt == N) { // 기저 조건
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) { // i : 주사위 눈
			numbers[cnt] = i;
			dice1(cnt + 1); // 유도 파트
		}

	}

	public static void dice2(int cnt, boolean[] isSelected) { // 주사위 던지기 2 : 순열nPr
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			if (isSelected[i])
				continue; // isSelected의 길이를 7로 두고 0번지를 비운 후 1~6번지를 사용한다

			numbers[cnt] = i;
			isSelected[i] = true;

			dice2(cnt + 1, isSelected);

			isSelected[i] = false;
		}

	}

	public static void dice3(int cnt, int start) { // 중복조합
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i); // 다음 주사위는 선택한 현재 수 부터 시도하도록 한다.
		}

	}

	public static void dice4(int cnt, int start) { // 조합

		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}
