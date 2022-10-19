import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BOJ_15684_사다리조작_G4_박지호 {

	private static int N, M, H, result;
	private static int[][] pan;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로 선 수 = 열의 수
		M = Integer.parseInt(st.nextToken()); // 가로 선 수
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치 = 행의 수
		result = 0;

		int[][] Mainmid = new int[M][2]; // 조합으로 뽑힌 가로선 정보 배열
		pan = new int[H + 1][N + 1]; // 전체 사다리 배열
//		boolean[][] visited = new boolean[H + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			pan[0][i] = 9;
		}
		for (int i = 0; i < H + 1; i++) {
			pan[i][0] = 9;
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			pan[a][b] = 1;

		}

		comb(0, 1, 1, Mainmid);
		System.out.println(result);
	}

	public static void comb(int cnt, int x, int y, int[][] mid) {
		if (cnt == M) {
			marking(mid);
			return;
		}

		if (pan[y][x] != 0) {
			if (y == H) {
				comb(cnt, y + 1, 1, mid);

			} else {
				comb(cnt, y, x + 1, mid);
			}
		}

		for (int i = x; i < N; i++) { // 세로를 고정시켜놓고
			for (int j = y; j < H + 1; j++) { // 가로를 움직이면서 본다
				if (pan[j][i - 1] == 0 && pan[j][i + 1] == 0) {
					mid[cnt][0] = j; // 0번지가 행값
					mid[cnt][1] = i; // 1번지가 열값
					cnt++;

					if (j == H) {
						comb(cnt, i + 1, 1, mid);
					} else {
						comb(cnt, i, j + 1, mid);
					}

				}
			}
		}

		return;
	}

	public static void marking(int[][] mid) {
		int[][] tempPan = new int[H + 1][N + 1];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < H + 1; j++) {
				tempPan[j][i] = pan[j][i];
			}
		}

		for (int i = 0; i < M; i++) {
			int r = mid[i][0];
			int c = mid[i][1];

			tempPan[r][c] = 1;

		}

		for (int i = 1; i < N + 1; i++) {
			int row = 1;
			int col = i;
			while (row <= H) {
				if (tempPan[row][col] == 1) {
					col++;
				} else if (tempPan[row][col - 1] == 1) {
					col--;
				}

				row++;

			}

			if (col == i) {
				result++;
			}

		} // end of for

	}

}

// 조합으로 사다리 위치 정한 다음
// 조합별로 탐색진행
