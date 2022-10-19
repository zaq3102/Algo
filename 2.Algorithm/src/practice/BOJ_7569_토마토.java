package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean isChange = true;
		int result = 0;

		int M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
		int H = Integer.parseInt(st.nextToken()); // 높이

		int[][][] box = new int[H][N][M];
		int[][][] map = new int[H][N][M];
		int[] dx = { -1, 1, 0, 0, 0, 0 }; // 상 하 좌 우 위 아래
		int[] dy = { 0, 0, -1, 1, 0, 0 }; // 상 하 좌 우 위 아래
		int[] dz = { 0, 0, 0, 0, 1, -1 }; // 상 하 좌 우 위 아래

		for (int i = 0; i < H; i++) { // 배열에 토마토 담기
			for (int j = 0; j < N; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int temp = Integer.parseInt(st2.nextToken());
					box[i][j][k] = temp;
					map[i][j][k] = temp;
				}
			}
		}

		while (isChange) {
			isChange = false;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						int idx = 0;
						int z = i;

						int y = j;
						int x = k;

						if (box[z][y][x] == -1)
							continue;

						while (idx < 6) {
							int fx = x + dx[idx];
							int fy = y + dy[idx];
							int fz = z + dz[idx];

							if (fx >= 0 && fy >= 0 && fz >= 0 && fx <= M - 1 && fy <= N - 1 && fz <= H - 1) {
								// 범위내
								// box, map은 H N M
								// M x : 가로 N y : 세로 H z : 높이

								if (box[fz][fy][fx] == 1) { // 인접토마토가 익었다면
//								System.out.println("test");
									map[z][y][x] = 1;
									isChange = true;
									break;
								}
							}
							idx++;
						} // end of while
					} // end of M
				} // end of N
			} // end of H
			if (Arrays.deepEquals(box, map)) {
				break;
			} else {

				for (int i = 0; i < H; i++) { // 배열에 토마토 담기
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							box[i][j][k] = map[i][j][k];
						}
					}
				}
				result++;
			}

		}

		ex: for (int i = 0; i < H; i++) { // 배열 출력
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						result = -1;
						break ex;

					}

				}

			}
		}
		System.out.println(result);

		for (int i = 0; i < H; i++) { // 배열 출력
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(map[i][j][k] + " ");
				}
				System.out.println();
			}
		}
	}
}

// 배열의 사방탐색을 응용해보자
// 익음 = 1 / 안익음 = 0 / 토마토없음 = -1
// fx = x + dx 를 먼저 해놓고 fx의 범위를 검사 => 배열을 벗어나는지 확인하고 시작
// 한 좌표에 대해서 상하좌우위아래 1이 있으면 현재 값을 1로 변경

// 토마토원본과 토마토지도를 활용
// 토마토 원본을 돌면서 육방탐색 진행 => 내일 익을 토마토를 토마토지도에 표시 
// 다음날 토마토지도를 토마토원본에 복사한 뒤 위의 과정 반복
// 이때 지도에 표시를 했다면 isChange = true
// isChange = false 일 경우 토마토가 모두 익었거나 모두 익지 못하는 상태

// 배열로 하면 시간초과가 난다 => 큐 사용할 것
