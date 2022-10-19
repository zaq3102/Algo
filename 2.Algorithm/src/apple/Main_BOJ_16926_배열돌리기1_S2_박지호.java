package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1_S2_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int min = N < M ? N : M;
		int[][] pan = new int[N][M];
		int[] dx = { 0, 1, 0, -1 }; // 우상좌하
		int[] dy = { 1, 0, -1, 0 }; // 우상좌하

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < min / 2; j++) {
				int x = j;
				int y = j;

				int value = pan[x][y];

				int idx = 0;

				while (idx < 4) {
					int fx = x + dx[idx];
					int fy = y + dy[idx];

					if (fx >= j && fy >= j && fx < N - j && fy < M - j) { // 범위안
						pan[x][y] = pan[fx][fy];
						x = fx;
						y = fy;

					} else { // 범위밖
						idx++;
					}

				}
				pan[j + 1][j] = value;

			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(pan[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
