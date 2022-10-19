package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_G5_박지호_524ms {
	static int result = 0;
	private static int[][] pan;
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<tomato> queue;

	public static class tomato {
		int x; // 행값
		int y; // 열값
		int days;

		public tomato(int x, int y, int days) {
			super();
			this.x = x;
			this.y = y;
			this.days = days;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
		pan = new int[N + 2][M + 2];
		queue = new LinkedList<tomato>();

		for (int i = 0; i <= M + 1; i++) {
			pan[0][i] = -1;
			pan[N + 1][i] = -1;
		}
		for (int i = 0; i <= N + 1; i++) {
			pan[i][0] = -1;
			pan[i][M + 1] = -1;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					queue.offer(new tomato(i, j, 0));
				}
				pan[i][j] = temp;
			}
		}
		getTomato();

		boolean check = true;
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				if (pan[i][j] == 0) {
					check = false;
					break;
				}
			}
		}
//

		if (check) {
			System.out.println(result);

		} else {
			System.out.println(-1);
		}
	}

	public static void getTomato() {

		while (!queue.isEmpty()) {
			boolean isChange = false;
			tomato temp = queue.poll();
			int r = temp.x;
			int c = temp.y;
			int day = temp.days + 1;

			for (int i = 0; i < 4; i++) {
				int dr = r + dx[i];
				int dc = c + dy[i];

				if (pan[dr][dc] == 0) {
					isChange = true;
					pan[dr][dc] = day;
					queue.offer(new tomato(dr, dc, day));
				}

			}

			if (!isChange) {
				result = day - 1;

			}
		}

	}
}
