package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거_박지호_134ms {

	private static int result;
	private static int[][] map;
	private static int N, M;
	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 }; // 상 하 좌 우
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로 크기 == 행의 수
			M = Integer.parseInt(st.nextToken()); // 가로 크기 == 열의 수
			int R = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 가로 위치
			int L = Integer.parseInt(st.nextToken()); // 탈출 후 소요 시간

			map = new int[N][M];
			result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C, L);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						result++;
					}
				}
			}

			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int r, int c, int time) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited = new boolean[N][M];

		queue.offer(new int[] { r, c, 1 });
		visited[r][c] = true;

		while (queue.size() != 0) {
			int[] temp = queue.poll();

			int x = temp[0];
			int y = temp[1];
			int cnt = temp[2];
			int pipe = map[x][y];

			if (cnt >= time) {
				continue;
			}

			switch (pipe) {
			case 1: // 상하좌우 0123
				for (int i = 0; i < 4; i++) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 0:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 1:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 2:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 3:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;

						}

					}

				}
				break;
			case 2: // 상하 01
				for (int i = 0; i < 2; i++) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 0:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 1:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}

				break;
			case 3: // 좌우 23
				for (int i = 2; i < 4; i++) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 2:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 3:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}
				break;
			case 4: // 상우 03
				for (int i = 0; i < 4; i += 3) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 0:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 3:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}
				break;
			case 5: // 하우 13
				for (int i = 1; i < 4; i += 2) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 1:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 3:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 6 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}
				break;
			case 6: // 하좌 12
				for (int i = 1; i < 3; i++) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 1:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 4 || nextPipe == 7) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 2:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}
				break;
			case 7: // 상좌 02
				for (int i = 0; i < 3; i += 2) {
					int fx = x + dx[i];
					int fy = y + dy[i];

					if (isOK(fx, fy) && !visited[fx][fy]) {
						int nextPipe = map[fx][fy];
						switch (i) {
						case 0:
							if (nextPipe == 1 || nextPipe == 2 || nextPipe == 5 || nextPipe == 6) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						case 2:
							if (nextPipe == 1 || nextPipe == 3 || nextPipe == 4 || nextPipe == 5) {
								queue.offer(new int[] { fx, fy, cnt + 1 });
								visited[fx][fy] = true;
							}
							break;
						}

					}

				}
				break;

			}

		}

	} // end of bfs

	public static boolean isOK(int x, int y) {

		if (x > -1 && y > -1 && x < N && y < M) {
			return true;
		}

		return false;
	}

}

// BFS
// 다음칸에 파이프가 잇어도 해당 파이프가 현재 파이프와 연결될 수 없는 상태라면 가지 못한다!!!
