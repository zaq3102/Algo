package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1961_숫자배열회전_D2_박지호_101ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append("\n");
			int N = Integer.parseInt(br.readLine());

			int[][] origin = new int[N][N];
			int[][] turn_90 = new int[N][N];
			int[][] turn_180 = new int[N][N];
			int[][] turn_270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());

					origin[i][j] = temp;
					turn_90[j][N - 1 - i] = temp;
					turn_180[N - 1 - i][N - 1 - j] = temp;
					turn_270[N - 1 - j][i] = temp;

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(turn_90[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(turn_180[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(turn_270[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

// 시계방향으로 90도 180도 270도 회전한 모습 출력
// N <= 7 이므로 그냥 배열 만들어서 해도 충분히 통과함