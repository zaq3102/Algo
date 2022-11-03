package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_B1_박지호_136ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] pan = new int[100][100];

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 10; j++) {

				for (int j2 = 0; j2 < 10; j2++) {
					if (pan[r + j][c + j2] == 1)
						continue;
					pan[r + j][c + j2] = 1;

				}

			} // 색칠 종료
			
		}
		int sum = 0;
		for (int j = 0; j < pan.length; j++) {
			for (int j2 = 0; j2 < pan.length; j2++) {
				sum += pan[j][j2];
			}
		}
		System.out.println(sum);
	}
}
