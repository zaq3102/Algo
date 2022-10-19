import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1806_부분합_G4_박지호2 {

	private static int[] arr;
	private static int N, S, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		doit(0, 0, 0);
		if (result == Integer.MAX_VALUE) {
			result = 0;
		}
		System.out.println(result);
	}

	public static void doit(int s, int e, int sum) {
		if (sum >= S && result > e - s) {
			result = e - s;
		}
		
		if (s >= N || e >= N) {
			return;
		}


		if (sum < S) {
			sum += arr[e];
			doit(s, e + 1, sum);
		} else {
			sum -= arr[s];
			doit(s + 1, e, sum);
		}

	}
}
