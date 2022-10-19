package hw;

import java.util.Scanner;

public class Solution_SWEA_5607_조합_D3_박지호 {
	private static long[] factorial;
	private static long MOD = 1234567891;
	private static int N, R;

	public static long pow(long a, long b) {

		if (b == 0)
			return 1;
		else if (b == 1)
			return a;

		if (b % 2 == 0) {
			long temp = pow(a, b / 2);
			return (temp * temp) % MOD;
		}

		long temp = pow(a, b - 1) % MOD;
		return (temp * a) % MOD;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		factorial = new long[1000001];
		factorial[0] = 1;

		for (int i = 1; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1]) % MOD;
		}

		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			R = sc.nextInt();

			long a = factorial[N];
			long b = (factorial[N - R] * factorial[R]) % MOD;

			b = pow(a, MOD - 2);

			sb.append("#").append(testCase).append(" ").append((a * b) % MOD).append("\n");

		}
		System.out.println(sb);

	}
}
