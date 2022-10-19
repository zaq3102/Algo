package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1215_회문1_D3_박지호_95ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {

			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			char[][] pan = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String line = br.readLine();
				for (int j = 0; j < 8; j++) {
					pan[i][j] = line.charAt(j);
				}
			}

			if (N % 2 == 1) {
				boolean check = false;
				for (int i = 0; i < 8; i++) {
					for (int j = N / 2; j < 8 - N / 2; j++) { // 가로로 한칸씩이동
						for (int j2 = 1; j2 <= N / 2; j2++) { // 회문검사 가로

							if (pan[i][j + j2] != pan[i][j - j2]) {
								check = false;
								break;
							}

							check = true;

						}
						if (check) {
							answer++;
						}

						for (int j2 = 1; j2 <= N / 2; j2++) { // 회문검사 세로
							if (pan[j + j2][i] != pan[j - j2][i]) {
								check = false;
								break;
							}

							check = true;

						}
						if (check) {
							answer++;
						}

					}
				}

			} else {
				boolean check = false;
				for (int i = 0; i < 8; i++) {
					for (int j = N / 2; j < 8 - N / 2 + 1; j++) {
						for (int j2 = 0; j2 < N / 2; j2++) {

							if (pan[i][j + j2] != pan[i][j - j2 - 1]) {
								check = false;
								break;
							}

							check = true;

						}
						if (check) {
							answer++;
						}

						for (int j2 = 0; j2 < N / 2; j2++) {

							if (pan[j + j2][i] != pan[j - j2 - 1][i]) {
								check = false;
								break;
							}
							check = true;
						}
						if (check) {
							answer++;
						}
					}
				}

			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		} // end of TC
		System.out.println(sb);

	} // end of main
}
