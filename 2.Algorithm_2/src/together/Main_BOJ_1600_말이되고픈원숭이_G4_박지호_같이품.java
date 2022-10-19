package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 상하좌우, 말처럼이동: 좌상 -> 우하단 으로 최단거리 이동 완탐, BFS 효율적 방문체크 : r,c,k
 * 
 */

public class Main_BOJ_1600_말이되고픈원숭이_G4_박지호_같이품 {

	static int[] hdx = { -2, -2, -1, -1, 1, 1, 2, 2 }; // 말이 이동할 수 있는 8방향
	static int[] hdy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dx = { 0, 1, 0, -1 }; // 원숭이가 이동할 수 있는 4방향
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 말처럼 뛸 수 있는 횟수, 0~30
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); // 가로길이 W, 1~200
		int H = Integer.parseInt(st.nextToken()); // 세로길이 H, 1~200

		int[][] m = new int[H][W];
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < W; j++, index += 2) {
				m[i][j] = s.charAt(index); // '0'평지, '1'장애물
			}
		}
		int minMoveCnt = -1; // 이동횟수 최소값

		boolean[][][] visited = new boolean[H][W][K];
		Queue<int[]> q = new LinkedList<int[]>(); // {r,c,k,moveCnt}
		q.offer(new int[] { 0, 0, K, 0 });
		visited[0][0][K] = true;
		while (q.size() > 0) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			K = arr[2];
			int moveCnt = arr[3];

			if(r == H-1 && c == W-1) { // 종료파트, 우측하단이면
				minMoveCnt = moveCnt;
				break;
			}
			
			
			if (K > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + hdx[i];
					int nc = c + hdy[i];
					if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][K - 1] && m[nr][nc] == '0') {
						visited[nr][nc][K - 1] = true;
						q.offer(new int[] { nr, nc, K - 1, moveCnt + 1 });
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc][K] && m[nr][nc] == '0') {
					visited[nr][nc][K] = true;
					q.offer(new int[] { nr, nc, K, moveCnt + 1 });
				}
			}

		}

		System.out.println(minMoveCnt);
	}
}
