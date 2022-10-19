package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기_같이품2 {

	static class Point {
		int r, c, cnt;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, W, H, min;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}

	static boolean go(int count, int[][] map) { // 중복순열 이용하여 구슬 던지기

		int result = getRemain(map);

		if (result == 0) { // 모든 벽돌이 부서졌다면
			min = 0;
			return true;
		}

		if (count == N) { // 모든 구슬을 다 던졌다면
			min = Math.min(min, result);

			return false;
		}

		int[][] newMap = new int[H][W];
		// 0열부터 W-1열까지 구슬 던져보기
		for (int c = 0; c < W; c++) {

			// 구슬에 맞는 벽돌 찾기
			int r = 0;
			while (r < H && map[r][c] == 0) {
				++r; // 빈공간이면 계속해서 아래로
			}
			if (r == H) {
				continue;
			}

			// 배열 상태 백업
			copy(map, newMap);
			boom(map, r, c); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
			down(newMap); // 부서진 벽돌 정리

			if (go(count + 1, newMap)) {
				return true;
			}
		}
		return false;
	}

	static void boom(int[][] map, int r, int c) { // r,c 위치에서 주변의 가능한 모든 벽돌도 함께 제거 처리
		Queue<Point> queue = new LinkedList<Point>();
		if (map[r][c] > 1) { // 벽돌 크기가 2 이상이면
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 자신은 제거처리(빈 공간으로) => visit 처리 역할

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;

				for (int k = 1; k < p.cnt; k++) { // 벽돌의 크기 -1 만큼 반복
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) { // 영향주는 벽돌
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0; // 빈 공간이면 그냥 0, 벽돌이면 제거 처리
					}
				}
			}
		}
	}

	static ArrayList<Integer> list = new ArrayList<Integer>();

	static void down(int[][] map) { // 부서진 벽돌 정리

		for (int c = 0; c < W; c++) {
			int r = H - 1; // 아래 행 시작
			while (r >= 0) {
				if (map[r][c] > 0) { // 내릴 벽돌 있나 확인
					list.add(map[r][c]);
					map[r][c] = 0;

				}
				r--;
			} // 부서지지 않고 남아있는 벽돌 리스트에 다 담기, 벽돌이 있던 자리는 빈 공간 처리됨

			r = H - 1;
			for (int a : list) { // 벽돌리스트
				map[r--][c] = a;
			}
			list.clear();
		}
	}

	static int getRemain(int[][] map) { // 남은 벽돌 수 리턴
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
}
