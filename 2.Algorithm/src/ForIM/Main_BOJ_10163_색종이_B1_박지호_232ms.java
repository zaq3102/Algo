package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10163_색종이_B1_박지호_232ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int[][] pan = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		int[] color = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + w; j++) { // 색종이 덮기
				for (int j2 = y; j2 < y + h; j2++) {
					pan[j][j2] = i;
				}
			}
		}

		for (int j = 0; j < pan.length; j++) {
			for (int j2 = 0; j2 < pan.length; j2++) {
				if (pan[j][j2] == 0)
					continue;
				color[pan[j][j2]]++;
			}
		}
//		for (int j = 0; j < 20; j++) {
//			for (int j2 = 0; j2 < 20; j2++) {
//
//				System.out.print(pan[j][j2]);
//			}
//			System.out.println();
//		}
//
		for (int i = 1; i < color.length; i++) {
			sb.append(color[i]).append("\n");
		}

		System.out.println(sb);
	}
}
