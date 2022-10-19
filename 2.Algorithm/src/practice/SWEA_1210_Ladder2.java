package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder2 {
	private static int[][] pan;
	private static boolean[][] check;
	static int cntL;
	static int cntR;
	static int result;
	static int startCnt;

	public static void start(int i, int j) {
		cntR = 0;
		cntL = 0;
		check[i][j] = true;

		if (i == 0) {
			result = j;
			return;
		}

		isRight(i, j);
		isLeft(i, j);

		if (cntL == 0 && cntR == 0) {
			start(i - 1, j);
		} else {
			start(i, j + cntR - cntL);
		}
	} // end of start

	public static void isRight(int i, int j) {
		if (j >= 99) {
			return;
		}
		if (pan[i][j + 1] == 1 && check[i][j + 1] == false) {
			cntR++;
			check[i][j] = true;
			isRight(i, j + 1);
		}

	} // end of isRight

	public static void isLeft(int i, int j) {
		if (j <= 0) {
			return;
		}
		if (pan[i][j - 1] == 1 && check[i][j - 1] == false) {
			cntL++;
			check[i][j] = true;
			isLeft(i, j - 1);

		}
	} // end of isLeft

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		pan = new int[100][100];
		result = 0;
		check = new boolean[100][100];

		for (int testCase = 1; testCase <= 1; testCase++) {
			int k = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			cntL = 0;
			cntR = 0;
			int fi = 0;
			int fj = 0;
			sb.append("#").append(testCase).append(" ");

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 100; j++) { // 사다리를 배열에 저장
					pan[i][j] = Integer.parseInt(st.nextToken());
					if (pan[i][j] == 2) {
						fi = i;
						fj = j;
					}
				}
			}

			start(fi - 1, fj); // 도착지점 한칸 위의 좌표를 넣는다
			sb.append(result).append("\n");
			System.out.println(sb);
		} // end of forTC
	} // end of main
}

// 사다리 정보를 배열에 저장
// 배열에 저장하면서 2인 경우를 찾는다 => 해당 경우의 i,j값을 시작값으로 설정
// 올라가면서 isleft isright 해준다
