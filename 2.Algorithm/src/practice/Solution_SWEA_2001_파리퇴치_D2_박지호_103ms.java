package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2001_파리퇴치_D2_박지호_103ms {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			String str = br.readLine();
			int N = str.charAt(0) - '0';
			int M = str.charAt(str.length() - 1) - '0';
			int sum = 0;
			int[][] field = new int[N][N];

			for (int i = 0; i < N; i++) { // 필드 배열화
				String temp = br.readLine();
				String[] temp_arr = temp.split(" ");
				for (int j = 0; j < temp_arr.length; j++) {
					field[i][j] = Integer.parseInt(temp_arr[j]);
				}
			} // 필드끝

			for (int i = 0; i <= N - M; i++) { // 전체 필드 탐색
				for (int j = 0; j <= N - M; j++) {
					int imsi = 0;

					for (int k = i; k < M + i; k++) { // M x M 칸 계산
						for (int k2 = j; k2 < M + j; k2++) {
							imsi += field[k][k2];

						}
					} // M x M 계산 끝
					if (sum < imsi) {
						sum = imsi;
					}
				}
			} // 필드 탐색 끝

			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
			sum = 0;
		} // 테케 끝
		System.out.println(sb.toString());
	} // 메인 끝

}
