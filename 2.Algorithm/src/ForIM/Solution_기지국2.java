package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_기지국2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 };

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());

			char[][] map = new char[N][];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			int nr, nc;
			// 기지국 찾기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] >= 'A' && map[r][c] <= 'C') { // 기지국이면
						// 기지국 주변 4방 탐색(4방향을 한칸씩 넓혀가며 탐색)
						for (int k = 1; k <= (map[r][c] - 'A') + 1; k++) {
						for (int d = 0; d < 4; d++) {
							nr = r;
							nc = c;

							// 기지국의 유형만큼 칸을 탐색
								nr += dr[d];
								nc += dc[d];
								if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 'H') {
									map[nr][nc] = 'X';
								}
							}

						} // 4방탐색

					} // if 기지국

				}
			}
			int hCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 'H')
						hCnt++;
				}
			}
			System.out.println("#" + testCase + " " + hCnt);
		} // end of TC

	}
}
