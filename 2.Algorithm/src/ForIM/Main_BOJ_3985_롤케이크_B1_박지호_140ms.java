package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3985_롤케이크_B1_박지호_140ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L + 1];
		int[][] people = new int[N + 1][2]; // 0번지가 예상 1번지가 실제

		int greedy = Integer.MIN_VALUE;
		int cnt = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int temp = K - P;
			people[i][0] = temp;
			if (temp >= greedy) {
				greedy = temp;
			}

			for (int j = P; j <= K; j++) {
				if (cake[j] != 0)
					continue;

				cake[j] = i;
				people[i][1]++;
			}

			cnt = people[i][1] > cnt ? people[i][1] : cnt;

		} // end of for

		for (int i = 1; i <= N; i++) {
			if (people[i][0] == greedy) {
				System.out.println(i);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (people[i][1] == cnt) {
				System.out.println(i);
				break;
			}
		}

	}
}

// 롤케이크 길이 L
// 방청객 수 N
// P 부터 K번 까지의 조각을 원한다
// 가장 많은 케이크 조각을 받을 것으로 기대한 방청객 = K-P 가 가장 큰 사람
// 실제 가장 많이 받은 방청객 = 배열에 본인 번호가 가장 많은 사람