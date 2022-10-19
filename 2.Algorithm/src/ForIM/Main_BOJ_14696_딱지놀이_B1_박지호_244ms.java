package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14696_딱지놀이_B1_박지호_244ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringTokenizer st2 = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st2 = new StringTokenizer(br.readLine(), " ");
			int A_size = Integer.parseInt(st.nextToken());
			int B_size = Integer.parseInt(st2.nextToken());
			int[] A = new int[5];
			int[] B = new int[5];

			for (int j = 0; j < A_size; j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			for (int j = 0; j < B_size; j++) {
				B[Integer.parseInt(st2.nextToken())]++;
			}

			for (int j = 4; j >= 1; j--) {
				if (A[j] > B[j]) {
					sb.append("A").append("\n");
					break;
				} else if (A[j] < B[j]) {
					sb.append("B").append("\n");
					break;
				}
				if (j == 1 && A[j] == B[j]) {
					sb.append("D").append("\n");
				}

			}

		}
		System.out.println(sb);
	}
}
// 별 > 동그라미 > 네모 > 세모