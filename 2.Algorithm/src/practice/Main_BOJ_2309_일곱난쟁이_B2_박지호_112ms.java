package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2309_일곱난쟁이_B2_박지호_112ms {
	private static int[] smf;
	private static int[] ans;
	static boolean isDone;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		smf = new int[9];
		ans = new int[7];
		isDone = false;
		sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			smf[i] = sc.nextInt();
		}

		Arrays.sort(smf);

		comb(0, 0);
		System.out.println(sb);
	}

	public static void comb(int cnt, int start) {
		if(isDone)
			return;

		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum += ans[i];
			}

			if (sum == 100) {
				isDone = true;
				for (int i = 0; i < ans.length; i++) {
					sb.append(ans[i]).append("\n");
				}
			}
			return;

		}

		for (int i = start; i < smf.length; i++) {
			ans[cnt] = smf[i];
			comb(cnt + 1, i + 1);
		}

	}

}
