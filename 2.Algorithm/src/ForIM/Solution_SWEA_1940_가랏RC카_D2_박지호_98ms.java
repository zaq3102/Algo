package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1940_가랏RC카_D2_박지호_98ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			int distance = 0;
			int speed = 0;

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int temp = Integer.parseInt(st.nextToken());
				if (temp == 0) { // 속도 유지
					distance += speed;
				} else if (temp == 1) { // 가속
					speed += Integer.parseInt(st.nextToken());
					distance += speed;
				} else { // 감속
					int minus = Integer.parseInt(st.nextToken());
					if (minus > speed) {
						speed = 0;
					} else {
						speed -= minus;
					}
					distance += speed;
				}
			}

			sb.append("#").append(testCase).append(" ").append(distance).append("\n");
		}
		System.out.println(sb);
	}
}
