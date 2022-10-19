package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1979_어디에단어가들어갈수있을까_D2_박지호_107ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> queue2 = new LinkedList<int[]>();
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] pan = new int[N][N];

			for (int i = 0; i < pan.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				boolean cannot = true;
				for (int j = 0; j < pan.length; j++) {
					int temp = Integer.parseInt(st.nextToken());
					pan[i][j] = temp;

					if (temp == 1 && cannot) {
						queue.offer(new int[] { i, j }); // 가로 빈칸 좌표
						cannot = false;
					}

					if (temp == 0) {
						cannot = true;
					}
				}
			}

			for (int i = 0; i < pan.length; i++) {
				boolean cannot2 = true;
				for (int j = 0; j < pan.length; j++) {
					if (pan[j][i] == 1 && cannot2) {
						queue2.offer(new int[] { j, i }); // 세로 빈칸 좌표
						cannot2 = false;
					}

					if (pan[j][i] == 0) {
						cannot2 = true;
					}
				}
			}
			int result = 0;
			while (!queue.isEmpty() || !queue2.isEmpty()) {
				if (!queue.isEmpty()) {
					int[] temp = queue.poll();
					int x = temp[0];
					int y = temp[1];

					int cnt = 0;

					for (int j = y; j < N; j++) {
						if (pan[x][j] == 1) {
							cnt++;
						} else {
							break;
						}
					}
					if (cnt == K) {
						result++;
					}

				}

				if (!queue2.isEmpty()) {
					int[] temp = queue2.poll();
					int x = temp[0];
					int y = temp[1];

					int cnt = 0;

					for (int j = x; j < N; j++) {
						if (pan[j][y] == 1) {
							cnt++;
						} else {
							break;
						}
					}
					if (cnt == K) {
						result++;
					}
				}

			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
// 각 행의 첫번째 빈칸 좌표를 큐에 입력
// 하나씩 뽑으면서 해당 좌표부터 빈칸이 연속되는 개수를 카운팅
// 