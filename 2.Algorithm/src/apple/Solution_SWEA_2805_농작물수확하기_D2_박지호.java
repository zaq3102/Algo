package apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2805_농작물수확하기_D2_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] pan = new int[N][N];

			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					pan[i][j] = temp.charAt(j) - '0';
				}

			}

			int answer = 0, area = 0, mid = (N / 2);
			for (int i = 0; i < N; i++) {
				int st = mid - area;
				int en = mid + area;

				for (int j = st; j <= en; ++j) {
					answer += pan[i][j];
				}

				if (i >= mid) {
					area--;
				} else {
					area++;
				}

			}

			System.out.println(answer);
		} // for 끝

	} // main 끝
}

//0행의 N/2 열 더하고
//1행의 N/2 + 1, N/2 , N/2 + 1 열 더하고 
//... N/2 -1 행까지
//
//N행의 N/2 열 더하고
//N-1행의 N/2 + 1, N/2 , N/2 + 1 열 더하고 
//... N/2 + 1 행까지
//
//마지막에 N 행 전부 더함
