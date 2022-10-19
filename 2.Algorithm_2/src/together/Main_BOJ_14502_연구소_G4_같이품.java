package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14502_연구소_G4_같이품 {
	private static int N, M;
	private static int[][] mapOrigin;
	private static int[][] map;
	private static int[][] arr0;
	private static int cntOrigin;
	private static int cnt;
	private static boolean[][] visited;
	private static int maxCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mapOrigin = new int[N][M];
		map = new int[N][M];
		arr0 = new int[8 * 8][2]; // 0의 좌표
		cntOrigin = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < M; j++, index += 2) {
				mapOrigin[i][j] = s.charAt(index);
				if (mapOrigin[i][j] == '0') {
					arr0[cntOrigin][0] = i;
					arr0[cntOrigin][1] = j;
					cntOrigin++;
				}
			}
		}
		// 2 <= 바이러스 개수 <= 10
		// 3 =< 빈칸
		maxCnt = 0;
		visited = new boolean[N][M];
		for (int a = 0; a < cntOrigin - 2; a++) { // 조합으로 0의 좌표들 중 3군데를 뽑아서 벽을 세우자 '1'
			for (int b = a + 1; b < cntOrigin - 1; b++) {
				for (int c = b + 1; c < cntOrigin; c++) {
					// 각 조합 결과를 새로운 카피맵에서 작업 mapOrigin => map
					for (int i = 0; i < N; i++) {
						System.arraycopy(mapOrigin[i], 0, map[i], 0, mapOrigin[i].length);
					}
					// 조합으로 선택한 3칸을 벽으로 놓기
					map[arr0[a][0]][arr0[a][1]] = '1';
					map[arr0[b][0]][arr0[b][1]] = '1';
					map[arr0[c][0]][arr0[c][1]] = '1';

					cnt = cntOrigin - 3; // 0의 개수, 벽 3개 놓음

					for (int i = 0; i < N; i++) {
						Arrays.fill(visited[i], false);
					}

					// DFS, BFS '2' 바이러스 퍼트리기, 안전영역 개수 카운팅, 최대값 업데이트
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (!visited[i][j] && map[i][j] == '2') { // 방문하지 않은, 바이러스를 퍼트리기
								dfs(i, j);
							}
						}
					}
					if (maxCnt < cnt)
						maxCnt = cnt;

				}
			}

		}
		System.out.println(maxCnt);
	}

	private static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dc = { 0, 0, -1, 1 };

	/** (r,c) 위치에서 부터 탐색 시작, 바이러스가 퍼질때마다 cnt 0을 감소 */
	private static void dfs(int r, int c) {
		if (0 > r || r >= N || 0 > c || c >= M || visited[r][c] || map[r][c] == '1') { // 종료 파트

			return;
		}

		visited[r][c] = true;
		if (map[r][c] == '0') {
			cnt--;
			map[r][c] = '2'; // 바이러스 퍼짐
		}

		for (int i = 0; i < 4; i++) {
			dfs(r + dr[i], c + dc[i]);
		}

	}
}
