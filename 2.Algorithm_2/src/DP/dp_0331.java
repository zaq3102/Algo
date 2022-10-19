package DP;

import java.util.Arrays;

public class dp_0331 {
	public static void main(String[] args) {
//	f(n) = 1~n까지 합
//	f(10) = 10+9+... +1 = 10 + f(9)
//	f(9) = 9+8+...+1

//		int[] memo = new int[11]; // 메모이제이션 활용
//		memo[1] = 1; 
//
//		for (int i = 2; i < memo.length; i++) {
//			memo[i] = i + memo[i - 1];
//		}
//		System.out.println(Arrays.toString(memo));

		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
			System.out.println(sum + " ");
		}
		System.out.println();

		for (int i = 1; i < 11; i++) {
			System.out.println((1 + i) * i / 2 + " ");
		}

	}

}
