package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7272_안경이없어_D3_박지호_156ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			String line1 = st.nextToken();
			String line2 = st.nextToken();

			if (line1.length() != line2.length()) {
				sb.append("#").append(testCase).append(" ").append("DIFF").append("\n");
				continue;
			} else {
				int N = line1.length();
				int[] arr1 = new int[N];
				int[] arr2 = new int[N];

				for (int i = 0; i < N; i++) {
					// ADOPQR
					if (line1.charAt(i) == 'A' || line1.charAt(i) == 'D' || line1.charAt(i) == 'O'
							|| line1.charAt(i) == 'P' || line1.charAt(i) == 'Q' || line1.charAt(i) == 'R') {
						arr1[i] = 1;
					} else if (line1.charAt(i) == 'B') {
						arr1[i] = 2;

					} else {
						arr1[i] = 0;

					}

					if (line2.charAt(i) == 'A' || line2.charAt(i) == 'D' || line2.charAt(i) == 'O'
							|| line2.charAt(i) == 'P' || line2.charAt(i) == 'Q' || line2.charAt(i) == 'R') {
						arr2[i] = 1;
					} else if (line2.charAt(i) == 'B') {
						arr2[i] = 2;

					} else {
						arr2[i] = 0;

					}

				}

				boolean isSame = true;
				for (int i = 0; i < N; i++) {
					if (arr1[i] != arr2[i]) {
						isSame = false;
						break;
					}
				}

				if (isSame) {
					sb.append("#").append(testCase).append(" ").append("SAME").append("\n");
				} else {
					sb.append("#").append(testCase).append(" ").append("DIFF").append("\n");
				}
			}

		}
		System.out.println(sb);
	}
}
