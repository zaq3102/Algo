package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4485_녹색옷입은애가젤다지_G4_박지호_256ms {
	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 };
	private static int N;
	private static int[][] pan;
	private static int[][] moneyMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;

		while (true) {

			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			pan = new int[N][N];
			moneyMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pan[i][j] = Integer.parseInt(st.nextToken());
					moneyMap[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs(0, 0);
			sb.append("Problem ").append(tc++).append(": ").append(moneyMap[N - 1][N - 1]).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { r, c });
		moneyMap[r][c] = pan[r][c];

		while (queue.size() != 0) {

			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int fx = x + dx[i];
				int fy = y + dy[i];

				if (fx > -1 && fy > -1 && fx < N && fy < N && moneyMap[fx][fy] > moneyMap[x][y] + pan[fx][fy]) {
					moneyMap[fx][fy] = moneyMap[x][y] + pan[fx][fy];
					queue.offer(new int[] { fx, fy });
				}
			}
		}
	}
}

// 일단 BFS