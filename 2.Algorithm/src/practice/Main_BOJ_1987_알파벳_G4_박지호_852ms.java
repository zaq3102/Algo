package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_박지호_852ms {
	private static char[][] pan;
	private static boolean[] apb;
	private static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	private static int[] dy = { 0, 1, 0, -1 };
	private static int R, C;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 세로 = 행 수
		C = Integer.parseInt(st.nextToken()); // 가로 = 열 수
		pan = new char[R + 2][C + 2];
		apb = new boolean[26]; // 0번지가 A 1번지가 B ...
		Arrays.fill(apb, false);

		for (int i = 0; i < R + 2; i++)
			pan[i][0] = pan[i][C + 1] = '-';
		for (int i = 0; i < C + 2; i++)
			pan[0][i] = pan[R + 1][i] = '-';

		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				pan[i][j] = str.charAt(j - 1);
			}
		}
		result = 1;
		apb[pan[1][1] - 'A'] = true;
		start(1, 1, 1);
		System.out.println(result);

	}

	public static void start(int sr, int sc, int cnt) {

		result = Math.max(result, cnt);
		for (int i = 0; i < 4; i++) {
			int nr = sr + dx[i];
			int nc = sc + dy[i];
			char now = pan[nr][nc];

			if (pan[nr][nc] != '-' && !apb[now - 'A']) {
				// 사방탐색한 칸의 알파벳이 방문한 적 있다면 혹은 값이 있는 마지막 인덱스라면
				apb[now - 'A'] = true; // 방문한 알파벳을 표시
				start(nr, nc, cnt + 1);
				apb[now - 'A'] = false; // 방문한 알파벳 해제
			}

		}
	}
}

// 어차피 최대로 이동가능한 칸수는 26개 => 26이상되면 break 걸어주면 시간빨라짐
