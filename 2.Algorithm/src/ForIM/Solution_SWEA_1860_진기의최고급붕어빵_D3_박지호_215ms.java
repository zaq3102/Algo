package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import practice.test;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_박지호_215ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int max = Integer.MIN_VALUE;
			int[] client = new int[N];
			for (int i = 0; i < N; i++) {
				client[i] = Integer.parseInt(st.nextToken());
				if (client[i] > max) {
					max = client[i];
				}
			}

			Arrays.sort(client);

			int bread = 0;
			int cnt = 0;
			boolean possible = true;

			if (client[0] == 0) { // 0초에 바로 오는 손님이 있다면
				possible = false;

			} else {

				for (int i = 1; i <= max; i++) { // 매 초마다 손님수와 붕어빵을 체크한다
					if (i % M == 0) { // M초마다 빵생산
						bread += K;
					}

					if (client[cnt] == i) { // i 초에 오는 손님이 있다면
						if (bread == 0) {
							possible = false;
							break;
						}
						cnt++;
						bread--;
					}

				}
			}

			if (possible) {
				sb.append("#").append(testCase).append(" ").append("Possible").append("\n");
			} else {
				sb.append("#").append(testCase).append(" ").append("Impossible").append("\n");

			}

		} // end of TC
		System.out.println(sb);
	}
}

// 손님수 N
// M 초 동안 K 개의 붕어빵 만듬