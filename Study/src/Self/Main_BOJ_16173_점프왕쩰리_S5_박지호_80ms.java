package Self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16173_점프왕쩰리_S5_박지호_80ms {
	static int N;
	private static int[][] pan;
	static boolean isHaru = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		pan = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		if (isHaru) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}

	} // end of main

	public static void dfs(int x, int y) {
		if (pan[x][y] == -1) {
			isHaru = true;
			return;
		}

		if (pan[x][y] == 0 || isHaru) {
			return;
		}

		int how = pan[x][y];

		if (x + how < N) {
			dfs(x + how, y);
		}

		if (y + how < N) {
			dfs(x, y + how);
		}
	}

}

// 점프값이 0인 경우를 간과해서 애먹음!!!!