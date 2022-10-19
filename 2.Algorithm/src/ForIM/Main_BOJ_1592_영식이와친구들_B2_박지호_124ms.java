package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1592_영식이와친구들_B2_박지호_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 친구 수
		int M = Integer.parseInt(st.nextToken()); // 목표 수
		int L = Integer.parseInt(st.nextToken()); // 건너뛰는 수

//		Deque<int[]> deque = new ArrayDeque<int[]>();
//		for (int i = 1; i <= N; i++) { // 덱에 친구들 넣어주기
//			deque.offer(new int[] { i, 0 });
//		}

		int[] friends = new int[N + 1];
		int cnt = 1;
		int result = 0;

		while (true) {

			if (friends[cnt] % 2 == 0) { // 짝수면
				if (cnt + L > N) {
					friends[cnt + L - N]++;
					cnt = cnt + L - N;
				} else {
					friends[cnt + L]++;
					cnt = cnt + L;
				}
			} else { // 홀수면
				if (cnt - L <= 0) {
					friends[cnt + (N - L)]++;
					cnt = cnt + (N - L);
				} else {
					friends[cnt - L]++;
					cnt = cnt - L;
				}
			}

			result++;
			if (friends[cnt] == M) {
				break;
			}
		}

//		System.out.println(Arrays.toString(friends));
		System.out.println(result-1);

	}
}

// 이차원배열을 담은 덱 친구인덱스,받은값
// 시계방향으로 돈다 => pollfirst 반시계 => polllast
// 받은 횟수가 홀수면 시계 / 짝수면 반시계