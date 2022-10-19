package apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_5215 { // 햄버거 다이어트

	static int TC, N, limit;
	static int[] happy;
	static int[] kcal;
	static boolean[] isSelected;
	static int sum;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		N = sc.nextInt();
		limit = sc.nextInt();

		happy = new int[N];
		kcal = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			happy[i] = sc.nextInt();
			kcal[i] = sc.nextInt();
		}
		calCalculate(0, 0, 0);
		System.out.println("#" + TC + " " + sum);
	}

	public static void calCalculate(int cal_sum, int hap_sum, int start) {
		if (start == N) { // 마지막 원소까지 부분집합에 다 고려된 상황
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					hap_sum += happy[i];
					cal_sum += kcal[i];
				}
			}
			if (cal_sum < limit && hap_sum > sum) {
				sum = hap_sum;
			}
			return;
		}
		// 현재 원소를 선택
		isSelected[start] = true;
		calCalculate(cal_sum, hap_sum, start + 1);

		// 현재 원소를 비선택
		isSelected[start] = false;
		calCalculate(cal_sum, hap_sum, start + 1);
	}
}
