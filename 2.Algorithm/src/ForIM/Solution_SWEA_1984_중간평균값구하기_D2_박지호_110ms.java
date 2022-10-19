package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기_D2_박지호_110ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= N; testCase++) {
			int[] arr = new int[10];
			st = new StringTokenizer(br.readLine(), " ");

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int answer = 0;

			for (int i = 0; i < 10; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp;

				if (temp > max) {
					max = temp;
				}

				if (temp < min) {
					min = temp;
				}

			}

			for (int i = 0; i < 10; i++) {
				if (arr[i] == max || arr[i] == min) {
					continue;
				}
				answer += arr[i];
			}
//			long result = (long) ((long)answer * 10 / 8);
			double result = Math.round((double)answer / 8.0);

			sb.append("#").append(testCase).append(" ").append((int)result).append("\n");
		}
		System.out.println(sb);

	}
}
