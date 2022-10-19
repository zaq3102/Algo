package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_같이품 {

	private static int[][] A;
	private static int[][] memo;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine()); // 1 <= N <= 10^3
			A = new int[N][N]; // 1 <= N*N <= 10^6
			memo = new int[N][N]; // 메모이제이션, 계산결과를 저장할 배열

			for (int i = 0; i < A.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < A.length; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0; // 최대 이동할 수 있는 방의 개수
			int num = 0; // 방번호 (가능하면 작은 수)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int val = go(r, c); // r,c 위치에서 시작해서 이동할 수 있는 최대 방의 개수 리턴
					if (max < val || (max == val && num > A[r][c])) { // 최대값이거나 같은 최대값일 경우 작은 숫자방을 선택
						max = val;
						num = A[r][c];
					}
				}
			}

			sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
		} // end of for testCase

		System.out.println(sb);
	} // end of main

	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	/** r, c 위치에서 시작해서 이동할 수 있는 최대 방 개수 리턴 */
	public static int go(int r, int c) {
		if(memo[r][c] != 0) {
			return memo[r][c]; // 메모값이 0이 아니다 = go메서드를 이미 거쳤다 = 이미 탐색한 원소다
		}
		memo[r][c] = 1;
		int num = A[r][c]; // 현재 방 숫자 임시 저장
		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 < nr && nr < N && 0 <= nc && nc < N && A[nr][nc] == num + 1) { // 나보다 1 크다면
				memo[r][c] += go(nr,nc);
				break; // 이 문장을 통해 시간 단축
			}
		}

		return memo[r][c]; // r,c에서 출발해서 최대 이동할 수 있는 방의 개수 리턴
	}
}
// 400ms => 250ms => 140
