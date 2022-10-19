import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17143_낚시왕_G2_박지호 {
	static class shark {

		int r; // 행
		int c; // 열
		int s; // 속력
		int d; // 방향
		int z; // 크기

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	private static int[] dx = { 0, -1, 1, 0, 0 }; // 상 하 우 좌
	private static int[] dy = { 0, 0, 0, 1, -1 }; // 상 하 우 좌
	private static int R, C, M, fisher, result;
	private static shark[][] map;
	private static Queue<shark> sharks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 0;

		R = Integer.parseInt(st.nextToken()); // 행 수
		C = Integer.parseInt(st.nextToken()); // 열 수
		M = Integer.parseInt(st.nextToken()); // 상어 수
		fisher = 0; // 낚시왕의 열 위치

		map = new shark[R + 1][C + 1];

		sharks = new LinkedList<shark>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks.offer(new shark(r, c, s, d, z));

			map[r][c] = new shark(r, c, s, d, z);
		}

		while (fisher < C) {
			// 1. 낚시왕 이동
			fisher++;

			// 2. 최상단 상어 캐치
			for (int i = 1; i <= R; i++) {
				if (map[i][fisher] != null) {
					result += map[i][fisher].z;
					// 맵에 상어 없애주고
					map[i][fisher] = null;

					// 큐에서 상어 없애준다
					int p = sharks.size();
					for (int j = 0; j < p; j++) {
						if (sharks.peek().r == i && sharks.peek().c == fisher) {
							sharks.poll();
							break;
						} else {
							sharks.offer(sharks.poll());
						}
					}
					break;
				}
			}

			// 3. 상어 이동

			map = new shark[R + 1][C + 1];
			int k = sharks.size();
			for (int i = 0; i < k; i++) {
				shark temp = move(sharks.poll());
				if (temp != null) {
					sharks.offer(temp);
				}
			}

		}
		System.out.println(result);

	} // end of main

	public static shark move(shark shk) {
		int r = shk.r;
		int c = shk.c;
		int d = shk.d;
		int s = shk.s;
		int z = shk.z;

		if (d < 3) { // 상 하
			int how = s % ((R) * 2); // 상어가 이동하는 거리 공식
			while (how > 0) {
				if (r == 1) {
					d = 2;
				}
				if (r == R) {
					d = 1;
				}

				r += dx[d];
				how--;
			}

		} else { // 좌 우
			int how = s % ((C) * 2); // 상어가 이동하는 거리 공식
			while (how > 0) {
				if (c == 1) {
					d = 3;
				}
				if (c == C) {
					d = 4;
				}

				c += dy[d];
				how--;
			}
		}

		if (map[r][c] != null) {
			if (map[r][c].z > z) { // 기존 값이 더 크면
				return null;
			} else { // 내가 더 크면
				map[r][c] = new shark(r, c, s, d, z);
				return new shark(r, c, s, d, z);
			}
		} else {
			map[r][c] = new shark(r, c, s, d, z);
			return new shark(r, c, s, d, z);
		}

	}
}

// 상어는 큐에 넣고 돌리는게 맞을듯?
// 1. 낚시왕 오른쪽 한칸 이동
// 2. 최상단 상어 잡기
// 3. 상어 이동
// ** 맵에 상어 크기를 저장 => 이동 시작 시 자신의 
