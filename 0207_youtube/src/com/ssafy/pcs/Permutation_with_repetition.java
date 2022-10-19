package com.ssafy.pcs;

import java.util.Arrays;

public class Permutation_with_repetition {
	// 선택하고자 하는 대상 집합.
	static int[] target = new int[] { 0, 1, 2, 3 };
	// 대상 숫자를 담아둘 배열을 만든다.
	static int[] result = new int[4];

	public static void main(String[] args) {
		permutation(0);
	}

	// 순열 메서드(cnt는 선택 횟수)
	private static void permutation(int cnt) {
		// 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
		if (cnt == 4) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 대상 집합을 순회하며 숫자를 하나 선택한다.
		for (int i = 0; i < 4; i++) {
			// 숫자를 담는다.
			result[cnt] = target[i];
			// 자신을 재귀 호출한다.
			permutation(cnt + 1);
		}
	}
}
