package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_2239_스도쿠_G4_박지호_448ms {

	private static int[][] pan;
	private static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pan = new int[9][9];
		list = new ArrayList<int[]>();

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				pan[i][j] = line.charAt(j) - '0';
				if (line.charAt(j) == '0') {
					list.add(new int[] { i, j });
				}

			}
		} // end of for

		dfs(0);

	} // end of main

	public static void dfs(int depth) {

		if (list.size() == depth) {
			print();
			System.exit(0);
		}

		int x = list.get(depth)[0];
		int y = list.get(depth)[1];

		boolean[] check = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (pan[x][i] != 0) {
				check[pan[x][i]] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (pan[i][y] != 0) {
				check[pan[i][y]] = true;
			}
		}

		int sqrX = (x / 3) * 3;
		int sqrY = (y / 3) * 3;

		for (int i = sqrX; i < sqrX + 3; i++) {
			for (int j = sqrY; j < sqrY + 3; j++) {
				if (pan[i][j] != 0) {
					check[pan[i][j]] = true;
				}
			}
		}

		for (int i = 1; i < 10; i++) {
			if (!check[i]) {
				pan[x][y] = i;
				dfs(depth + 1);
				pan[x][y] = 0;
			}
		}

	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(pan[i][j]);
			}
			System.out.println();
		}
	}

} // end of class

// 0 자리를 받아와서
// DFS, 방문처리