package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기_박지호_1181ms {

	private static int N, W, H, max, totalbrick;
	private static int[][] pan;
	private static int[] shootOrder;
	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 }; // 상 하 좌 우

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬 발사 횟수
			W = Integer.parseInt(st.nextToken()); // 가로 = 열의 개수
			H = Integer.parseInt(st.nextToken()); // 세로 = 행의 개수
			shootOrder = new int[N];
			max = Integer.MIN_VALUE;
			totalbrick = 0;

			pan = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					pan[i][j] = Integer.parseInt(st.nextToken());
					if (pan[i][j] != 0) {
						totalbrick++;
					}
				}
			}

			permutation(0);
			if (max < 0) {
				max = totalbrick;
			}
			sb.append("#").append(testCase).append(" ").append(totalbrick - max).append("\n");

		}
		System.out.println(sb);

	}

	private static void permutation(int cnt) {
		// 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
		if (cnt == N) {
			shootStart();
			return;
		}
		// 대상 집합을 순회하며 숫자를 하나 선택한다.
		for (int i = 0; i < W; i++) {
			// 숫자를 담는다.
			shootOrder[cnt] = i;
			// 자신을 재귀 호출한다.
			permutation(cnt + 1);
		}
	}

	private static void shootStart() {
		int tempResult = 0;
		int[][] tempPan = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tempPan[i][j] = pan[i][j];
			}
		}

		for (int i = 0; i < N; i++) {

			int idx = 0;
			while (true) {
				if (idx == H) {
					return;
				}
				if (tempPan[idx][shootOrder[i]] == 0) {
					idx++;
					continue;
				} else {
					break;
				}
			}

			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] { idx, shootOrder[i], tempPan[idx][shootOrder[i]] }); // 행, 열, 값

			while (queue.size() != 0) {
				int[] brick = queue.poll();

				int x = brick[0]; // 행번호
				int y = brick[1]; // 열번호
				int val = brick[2];

				for (int j = 0; j < 4; j++) {

					for (int j2 = 0; j2 < val; j2++) {
						int fx = x + dx[j] * j2;
						int fy = y + dy[j] * j2;

						if (fx > -1 && fy > -1 && fx < H && fy < W && tempPan[fx][fy] != 0) {
							queue.offer(new int[] { fx, fy, tempPan[fx][fy] });
							tempPan[fx][fy] = 0;
							tempResult++;
						}

					}
				}

			} // end of while

			// 여기서 중력작용
			for (int j = 0; j < W; j++) {
				for (int j2 = H - 1; j2 > -1; j2--) {
					if (tempPan[j2][j] != 0) {
						int nr = j2;
						while (true) {
							nr++;
							if (nr < H && tempPan[nr][j] == 0) {
								tempPan[nr][j] = tempPan[nr - 1][j];
								tempPan[nr - 1][j] = 0;
							} else {
								break;
							}

						}
					}

				}
			}

		} // end of for_N

		max = tempResult > max ? tempResult : max;

	} // end of shootStart

}

// 구슬 발사하는 순서를 중복순열로 구한 다음 => 0값만 있는 열을 골랐다면? 그냥 CONTINUE 해버리는 가지치기 가능할지도
// 순서를 가지고 게임 실행

// 깨진 벽돌의 값-1 에 해당되는 범위의 상하좌우 벽돌을 큐에 담는다
// 이 큐를 가지고 연쇄작용 => BFS

// 