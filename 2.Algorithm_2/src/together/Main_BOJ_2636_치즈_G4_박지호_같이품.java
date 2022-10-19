package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 가장자리에는 치즈가 없다 치즈가 모두 녹아서 없어지는 시간 출력 다 녹기 한 시간 전에 남아있는 치즈 조각 개수
 * 
 * 카운팅, BFS
 * 
 */
public class Main_BOJ_2636_치즈_G4_박지호_같이품 {
	private static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); // 사각형 판의 세로, 1 <= R, C <= 100
		int C = Integer.parseInt(st.nextToken()); // 사각형 판의 가로

		int[][] m = new int[R + 2][C + 2];
		int total = 0; // 치즈 총 개수

//		for (int i = 1; i <= R; i++) {
//			String s = br.readLine();
//			for (int j = 1; j <= C; j++) {
//				m[i][j] = s.charAt(j-1); // '1'치즈 '0'공기
//				if (m[i][j] == '1')
//					total++;
//			}
//		}
		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1, index = 0; j <= C; j++, index += 2) {
				m[i][j] = s.charAt(index); // '1'치즈 '0'공기
				if (m[i][j] == '1')
					total++;
			}
		}
//		for (int i = 0; i < m.length; i++) {
//			m[i][0] = m[i][C + 1] = 9;
//		}
//		for (int i = 0; i < m[i].length; i++) {
//			m[0][i] = m[R + 1][i] = 9;
//		}

		int time = 0; // 치즈가 모두 녹을 때 총 걸리는 시간
		int cnt = 0; // 마지막 시간에 제거된 치즈 개수

		boolean[][] visited = new boolean[R + 2][C + 2];
		Queue<int[]> q = new LinkedList<int[]>(); // 행, 열
		while (total > 0) { // 공기와 닿은 치즈 녹이기 / 치즈가 모두 녹을 때까지
			time++;
			cnt = 0;
			// BFS 공기와 닿은 치즈를 녹이기, 이번 시간에 녹은 치즈의 개수를 CNT에 카운팅

			for (int i = 0; i < visited.length; i++) {
				Arrays.fill(visited[i], false);
			}
			
			int sr = 1; // 탐색 시작 좌표(치즈 없는 가장자리)
			int sc = 1;
			q.offer(new int[] { sr, sc });
			visited[sr][sc] = true;

			while (q.size() > 0) { // 큐가 빌 때까지 반복
				int[] arr = q.poll();
				sr = arr[0];
				sc = arr[1];
				// 인접 칸이 공기(=0)이면 큐에 넣기
				// 인접 칸이 치즈(=1)이면 치즈 제거
				for (int i = 0; i < dr.length; i++) {
					int nr = sr + dr[i];
					int nc = sc + dc[i];
					if (m[nr][nc] != 0 && !visited[nr][nc]) { // 배열 범위 내 & 방문하지 않았고 & 인접했다면
						if (m[nr][nc] == '0') {
							q.offer(new int[] { nr, nc });
						} else { // 치즈 이면
							m[nr][nc] = '0';
							cnt++;
						}
						visited[nr][nc] = true; // 방문 표시

					}

				}

			}
			// 제거한 치즈를 전체 치즈의 개수에서 빼기
			
			total -= cnt;
			
		}
		System.out.println(time + "\n" + cnt);

	} // end of main

} // end of class
