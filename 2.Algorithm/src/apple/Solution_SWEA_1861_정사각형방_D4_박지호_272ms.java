package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_박지호_272ms {

	static int[][] sqr;
	static int cnt;

	public static void compare(int i, int j) {
		if (sqr[i][j] == 0) {
			return;
		}
		int temp = sqr[i][j] + 1;

		if (temp == sqr[i - 1][j]) { // 위
			cnt++;
			compare(i - 1, j);
		}
		if (temp == sqr[i + 1][j]) { // 아래
			cnt++;
			compare(i + 1, j);
		}
		if (temp == sqr[i][j + 1]) { // 오른쪽
			cnt++;
			compare(i, j + 1);
		}
		if (temp == sqr[i][j - 1]) { // 왼쪽
			cnt++;
			compare(i, j - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(testCase).append(" ");
			sqr = new int[N + 2][N + 2];

			Stack<int[]> result = new Stack<int[]>();

			for (int i = 1; i <= N; i++) { // 정사각형 방 만들기
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					sqr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= sqr.length - 2; i++) {
				for (int j = 1; j <= sqr.length - 2; j++) {
					cnt = 1;
					compare(i, j);
					result.push(new int[] { sqr[i][j], cnt });
				}
			}

			int[] max = new int[] { 0, 0 };

			for (int i = 0; i < N * N; i++) {
				int[] last = result.pop();
				if (last[1] > max[1]) {
					max = last;
				} else if (last[1] == max[1]) {
					if (last[0] < max[0]) {
						max = last;
					}
				}
			}
			sb.append(max[0]).append(" ").append(max[1]).append("\n");
		}
		System.out.println(sb);
	} // end of main
}

// 배열 집어넣고
// 배열[i][j] 칸의 상 하 좌 우 칸의 값을 비교하여
// +1 값을 가진 칸이 있으면 해당 칸으로 이동
// 해당 칸에서 다시 상하좌우 탐색
