package Self;

import java.util.LinkedList;
import java.util.Queue;

public class skill_check_1 {

	public static void main(String[] args) {
//		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
//				{ 0, 0, 0, 0, 1 } };
		int[][] maps = { { 1,0,1,1,1 }, { 1,0,1,0,1 }, { 1,0,1,1,1 }, { 1,1,1,0,0 },
				{ 0,0,0,0,1 } };
		

		System.out.println(solution(maps));
	}

	private static int[][] new_map;
	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 }; // 상 하 좌 우
	private static boolean[][] visited;
	private static int n, m, min;

	public static int solution(int[][] maps) {
		n = maps.length; // 행 수
		m = maps[0].length; // 열 수
		min = Integer.MAX_VALUE;

		new_map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1]; // 빈공간은 true

		for (int i = 0; i < n + 1; i++) {

			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					new_map[i][j] = 0;
					continue;
				}

				new_map[i][j] = maps[i - 1][j - 1];

				if (maps[i - 1][j - 1] == 1) {
					visited[i][j] = true;
				}

			}
		}

//		for (int i = 0; i < maps.length; i++) {
//			for (int j = 0; j < maps[0].length; j++) {
//				System.out.print(maps[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		for (int i = 0; i < new_map.length; i++) {
//			for (int j = 0; j < new_map[0].length; j++) {
//				System.out.print(new_map[i][j] + " ");
//			}
//			System.out.println();
//		}

		bfs();

		int answer = 0;

		if (min == Integer.MAX_VALUE) {
			answer = -1;
		} else {
			answer = min;
		}

		return answer;
	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { 1, 1, 0 });
		visited[1][1] = false;

		while (queue.size() != 0) {
			int[] temp = queue.poll();

			int x = temp[0];
			int y = temp[1];
			int cnt = temp[2];

			if (x == n && y == m) {
				min = Integer.min(min, cnt + 1);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int fx = x + dx[i];
				int fy = y + dy[i];

				if (fx >= 0 && fy >= 0 && fx <= n && fy <= m && new_map[fx][fy] == 1 && visited[fx][fy]) {
					queue.offer(new int[] { fx, fy, cnt + 1 });
					visited[fx][fy] = false;
				}

			}
		}

	}

}


// ROR 게임 문제
// n x m
// 0은 벽 1은 빈공간
// 캐릭터 시작 위치 : 1,1 (= 좌상단) 
// 도착지 위치 : n,m (=우하단)

// 최소 칸 수 리턴
