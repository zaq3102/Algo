package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1249_보급로_D4_박지호_160ms {

	private static int[][] pan;
	private static int N, min;
	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] visited;

	public static class pos {
		int x;
		int y;
		int sum;

		public pos() {
			// TODO Auto-generated constructor stub
		}

		public pos(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			visited = new int[N][N];
			pan = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					pan[i][j] = line.charAt(j) - '0';
					visited[i][j] = Integer.MAX_VALUE;
				}
			}

			bfs();
			sb.append("#").append(testCase).append(" ").append(visited[N - 1][N - 1]).append("\n");

		}
		System.out.println(sb);

	}

	public static void bfs() {
		Queue<pos> queue = new LinkedList<pos>();

		queue.offer(new pos(0, 0, pan[0][0]));
		visited[0][0] = pan[0][0];

		while (queue.size() != 0) {
			pos temp = queue.poll();

			int x = temp.x;
			int y = temp.y;
			int sum = temp.sum;
			if (visited[x][y] < sum) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int fx = x + dx[i];
				int fy = y + dy[i];

				if (fx > -1 && fy > -1 && fx < N & fy < N && visited[fx][fy] > sum + pan[fx][fy]) {
					queue.offer(new pos(fx, fy, sum + pan[fx][fy]));
					visited[fx][fy] = sum + pan[fx][fy];
				}

			}

		}

	}

}

// 맵 받아서 BFS 로 값이 최소인 경로를 찾는다
// 끝.