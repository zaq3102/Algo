package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1220_Magnetic_D3_박지호_178ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int res = 0;

			int[][] pan = new int[N][N];

			for (int i = 0; i < pan.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < pan.length; j++) {
					pan[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 1 : N  / 2 : S / 0 : 공백
			
			for (int j = 0; j < N; j++) {
				int sw = 0; // 1이면 N만남, 0이면 아무것도 아님
				for (int i = 0; i < N; i++) {
					
					if(pan[i][j] == 0) {
						continue;
					}
					if(pan[i][j] == 2 && sw == 1) { // S극만남
						res++;
					}
					// 1인 경우, 2인 경우
					sw = pan[i][j];
				}
			}
			System.out.println("#" + tc + " " + res);
		}

	}
}
