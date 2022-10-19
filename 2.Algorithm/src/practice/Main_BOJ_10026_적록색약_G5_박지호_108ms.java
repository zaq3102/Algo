package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적록색약_G5_박지호_108ms {

	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 }; // 우 하 좌 상
	static int result, GRresult;
	private static char[][] pan;
	private static char[][] GRpan;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pan = new char[N + 2][N + 2];
		GRpan = new char[N + 2][N + 2];
		result = 0;
		GRresult = 0;

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				pan[i][j] = line.charAt(j - 1);
				if (line.charAt(j - 1) == 'G') {
					GRpan[i][j] = 'R';
				} else {
					GRpan[i][j] = line.charAt(j - 1);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (pan[i][j] != 'C') {
					bfs(new int[] { i, j });
					result++;
				}
				if (GRpan[i][j] != 'C') {
					GRbfs(new int[] { i, j });
					GRresult++;
				}

			}
		}
		System.out.println(result + " " + GRresult);
	}

	public static void GRbfs(int[] start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(start);
		char temp = GRpan[start[0]][start[1]];
		GRpan[start[0]][start[1]] = 'C';
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();

			int x = loca[0];
			int y = loca[1];

			for (int i = 0; i < 4; i++) {
				if (GRpan[x + dx[i]][y + dy[i]] == temp && GRpan[x + dx[i]][y + dy[i]] != 'C') {
					queue.offer(new int[] { x + dx[i], y + dy[i] });
					GRpan[x + dx[i]][y + dy[i]] = 'C';
				}
			}

		}

	}

	public static void bfs(int[] start) { // 일반인 경우 구역 탐색
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(start);
		char temp = pan[start[0]][start[1]];
		pan[start[0]][start[1]] = 'C';
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();

			int x = loca[0];
			int y = loca[1];

			for (int i = 0; i < 4; i++) {
				if (pan[x + dx[i]][y + dy[i]] == temp && pan[x + dx[i]][y + dy[i]] != 'C') {
					queue.offer(new int[] { x + dx[i], y + dy[i] });
					pan[x + dx[i]][y + dy[i]] = 'C';
				}
			}

		}

	}

}

// 구역을 구분짓는 문제
// 원본배열 & 방문배열 => 시간초과나니까 원본배열을 수정해주는 방법이 좋을 것
// BFS or DFS + 방문체크