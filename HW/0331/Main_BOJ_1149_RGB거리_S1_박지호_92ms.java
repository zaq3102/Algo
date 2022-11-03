package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리_S1_박지호_92ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] color = new int[N][3];

		for (int i = 0; i < N; i++) { // 초기 값 설정
			st = new StringTokenizer(br.readLine());

			color[i][0] = Integer.parseInt(st.nextToken()); // R
			color[i][1] = Integer.parseInt(st.nextToken()); // G
			color[i][2] = Integer.parseInt(st.nextToken()); // B

		}

		for (int i = 1; i < N; i++) { // 이전 값 중 나와 다른 두 값의 최소값을 현재 내 값에 더해준다
			color[i][0] += Math.min(color[i - 1][1], color[i - 1][2]);
			color[i][1] += Math.min(color[i - 1][0], color[i - 1][2]);
			color[i][2] += Math.min(color[i - 1][0], color[i - 1][1]);

		}

		System.out.println(Math.min(Math.min(color[N - 1][0], color[N - 1][1]), color[N - 1][2]));

	}
}
