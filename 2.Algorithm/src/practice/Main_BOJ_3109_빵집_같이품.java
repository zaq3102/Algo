package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시뮬레이션 + Greedy 위쪽 행부터 순차적으로 한 행씩 싲가해서 우선순위(1우상,2우,3우하)대로 탐색
 */
public class Main_BOJ_3109_빵집_같이품 {
	private static char[][] M;
	private static int R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = new char[R][];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			M[i] = s.toCharArray(); // 이게 더 빠르다
//			for (int j = 0; j < C; j++) {
//				M[i][j] = s.charAt(j); // 이건 좀 느리다
//			}
		}

		int cnt = 0;
		for (int r = 0; r < R; r++) { // 각 행별로 한 번씩 출발해본다
			if (go(r, 0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	/**
	 * r,c 위치에서 탐색 연결되었으면 true 리턴
	 */
	public static boolean go(int r, int c) {
		M[r][c] = 'x'; // 자취 남기자

		if (c == C - 1) { // 마지막 칸에 도착하면 => 기저조건
			return true;
		}
		boolean isConnect = false;
		int nr = r - 1;
		int nc = c + 1;
		if (0 <= nr && M[nr][nc] == '.') {
			isConnect = go(nr, nc); // 우상
		}
		if (isConnect)
			return true;

		nr = r;
		if (M[nr][nc] == '.') {
			isConnect = go(nr, nc); // 우
		}
		if (isConnect)
			return true;
		nr = r + 1;
		if (nr < R && M[nr][nc] == '.') {
			isConnect = go(nr, nc); // 우하
		}

		return isConnect;
	}
}
