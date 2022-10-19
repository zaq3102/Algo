package practice;

import java.util.Scanner;

public class Solution_SWEA_1206_View_D3_박지호_같이품 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		for (int t = 1; t <= TC; t++) {
			int res = 0;
			int N = sc.nextInt();
			int[] map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
			// 2번째 부터 N-2번째까지 모든 건물에서 계산
			for (int i = 2; i < N - 2; i++) {
				// 왼쪽에서 두개 중에 큰값찾기
				int left1 = map[i - 1];
				int left2 = map[i - 2];
				int left = Math.max(left1, left2);
				// 오른쪽에서 두개 중에 큰값찾기
				int right1 = map[i + 1];
				int right2 = map[i + 2];
				int right = Math.max(right1, right2);
				// 나와 왼쪽 오른쪽 의 차이값(조망권이 보장된 세대수
				int me = map[i];
				int lcha = me - left;
				int rcha = me - right;
				if (lcha > 0 && rcha > 0) {// 조망권 보장 양수, 양수(0) 포함
					res += Math.min(lcha, rcha);
				}
			}
			System.out.println("#" + t + " " + res);
		}

	}

}
