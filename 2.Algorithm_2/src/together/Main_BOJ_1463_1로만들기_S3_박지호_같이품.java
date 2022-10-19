package together;

import java.util.Scanner;

public class Main_BOJ_1463_1로만들기_S3_박지호_같이품 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] memo = new int[X + 3];

		for (int i = 2; i <= X; i++) {
			memo[i] = memo[i - 1] + 1; // 1을 빼보기
			if (i % 2 == 0) { // 2로 나눠보기
				memo[i] = Math.min(memo[i / 2] + 1, memo[i]);
			}
			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i / 3] + 1, memo[i]);
			}

		}
		System.out.println(memo[X]);
	}
}

// DP 상향식 방법

// DP 하향식 방법
// m[1] = 0
// m[2] = 1
// m[3] = 1
// m[4] = 2
//
// m[6] = 2
//
//
// m[9] = 2

