package together;

import java.util.Scanner;

public class Main_BOJ_1463_1로만들기_S3_박지호_같이품2 {
	private static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		memo = new int[X + 1];
		System.out.println(topDown(X));

	}

	private static int topDown(int X) {
		if (X == 1) { // 기저파트
			return 0;
		}
		if (memo[X] > 0) {
			return X;
		}
		int min = topDown(X - 1); // 1로 빼보자

		if (X % 3 == 0) { // 3으로 나눠보자
			min = Math.min(min, topDown(X / 3));
		}

		if (X % 2 == 0) { // 2로 나눠보자
			min = Math.min(min, topDown(X / 2));
		}
		memo[X] = min + 1;
		return min + 1;
	}
}

// 재귀함수로 구현
// 중복연산이 많이 발생, 콜스택 사용 => DP를 사용하는 이유
