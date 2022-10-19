package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7236_저수지의물의총깊이구하기_D3_박지호_108ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int res = 0;

			char[][] pan = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					pan[i][j] = st.nextToken().charAt(0);
				}
			}
			// 2차원 맵 탐색하면서 W인 곳의 8방탐색 후 W개수 카운팅
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (pan[i][j] == 'W') {
						int cnt = 0;
						// 팔방탐색 시작
						if (i - 1 >= 0 && pan[i - 1][j] == 'W') {
							cnt++;
						}
						if (i + 1 < N && pan[i + 1][j] == 'W') {
							cnt++;
						}
						if (j - 1 >= 0 && pan[i][j - 1] == 'W') {
							cnt++;
						}
						if (j + 1 < N && pan[i][j + 1] == 'W') {
							cnt++;
						}
						if (i - 1 >= 0 && j - 1 >= 0 && pan[i - 1][j - 1] == 'W') {
							cnt++;
						}
						if (i - 1 >= 0 && j + 1 < N && pan[i - 1][j + 1] == 'W') {
							cnt++;
						}
						if (i + 1 < N && j - 1 >= 0 && pan[i + 1][j - 1] == 'W') {
							cnt++;
						}
						if (i + 1 < N && j + 1 < N && pan[i + 1][j + 1] == 'W') {
							cnt++;
						}

						res = Math.max(res, cnt);
					}
				}
			}

			if (res == 0)
				res++;
			sb.append("#").append(testCase).append(" ").append(res).append("\n");

		}
		System.out.println(sb);

	}
}
