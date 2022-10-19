package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2629_양팔저울_G3_월말평가 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] chu = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] memo = new boolean[N][30 * 500 + 1]; // 추 30개 무게 500 => 최대가짓수
		memo[0][0] = true;
		memo[0][chu[0]] = true; // 첫번째 추 고려하는 것은 직접 입력
		for (int i = 1; i < N; i++) { // i개수 만큼 추를 고려하겠다
			for (int j = 0; j < memo[i].length; j++) { // 확인할 무게
				if (memo[i - 1][j])
					continue; // 만들수 없는 무게에는 적용하지 않는다
				memo[i][j] = true; // 이전에 가능했던 무게는, 이번 추를 고려해도 가능한 무게
				int a = j + chu[i];
				int b = j - chu[i];
				if (b < 0)
					b = -b;

				memo[i][a] = true;
				memo[i][b] = true;
			}
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			sb.append(x <= 15000 && memo[N - 1][x] ? "Y" : "N");
		}
		System.out.println(sb.toString());
	}
}
