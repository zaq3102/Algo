package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_2239_스도쿠_G4_같이품 {

	private static int[][] a = new int[9][9];
	private static boolean c1[][] = new boolean[10][10]; // 행
	private static boolean c2[][] = new boolean[10][10]; // 열
	private static boolean c3[][] = new boolean[10][10]; // 구획

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				a[i][j] = line.charAt(j) - '0';
				if (a[i][j] != 0) {
					c1[i][a[i][j]] = true;
					c2[j][a[i][j]] = true;
					c3[square(i, j)][a[i][j]] = true;
				}
			}
		} // end of for

		go(0);

	} // end of main

	/** z번째 칸에 값 채워보기, z칸=(z/9행, z%9열) */
	private static void go(int z) {
		if (z == 81) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(a[i][j]);
				}
				sb.append("\n");
			}

			System.out.println(sb);
			System.exit(0);
		}

		int r = z / 9;
		int c = z % 9;
		if (a[r][c] != 0) { // 숫자인 경우 다음으로 넘어가기
			go(z + 1);
			return;
		} else { // 0인 경우 빈칸 값 채우기
			for (int i = 1; i <= 9; i++) {
				if (!c1[r][i] && !c2[c][i] && !c3[square(r, c)][i]) {
					a[r][c] = i;
					c1[r][i] = true;
					c2[c][i] = true;
					c3[square(r, c)][i] = true;

					go(z + 1);
					a[r][c] = 0;
					c1[r][i] = false;
					c2[c][i] = false;
					c3[square(r, c)][i] = false;

				}
			}
		}
	}

	/** r행c열 좌표를 1개의 숫자로 표현 */
	public static int square(int r, int c) {
		return (r / 3) * 3 + c / 3;
	}

} // end of class

// 0 자리를 받아와서
// DFS, 방문처리