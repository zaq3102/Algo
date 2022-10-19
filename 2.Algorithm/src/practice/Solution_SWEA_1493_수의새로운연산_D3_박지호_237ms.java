package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1493_수의새로운연산_D3_박지호_237ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int p_x = 0;
			int p_y = 0;
			int q_x = 0;
			int q_y = 0;

			boolean ok_p = false;
			boolean ok_q = false;
			int cnt_p = 1;
			int cnt_q = 1;
			while (!ok_p || !ok_q) {

				if (!ok_p) {
					if (p - cnt_p > 0) {
						p -= cnt_p;
					} else {
						p_x = p;
						p_y = cnt_p + 1 - p;
						ok_p = true;
					}
					cnt_p++;
				}
				if (!ok_q) {
					if (q - cnt_q > 0) {
						q -= cnt_q;
					} else {
						q_x = q;
						q_y = cnt_q + 1 - q;
						ok_q = true;
					}
					cnt_q++;
				}

			}

			int fx = p_x + q_x;
			int fy = p_y + q_y;
			int answer = 0;

			ex: for (int i = 1;; i++) {
				for (int x = 1, y = i; x <= i; x++, y--) {
					if (x == fx && y == fy) {
						break ex;
					}
					answer++;
				}
			}

//			System.out.println(p_x);
//			System.out.println(p_y);
//			System.out.println(q_x);
//			System.out.println(q_y);
			sb.append("#").append(testCase).append(" ").append(answer + 1).append("\n");
//			System.out.println(answer+1);

		}
		System.out.println(sb);
	}
}

// 1,1 + 1,2 = 2,3

// 첫 숫자가 적힌 좌표 + 두번째 숫자가 적힌 좌표 => 합산한 좌표에 있는 값 구하기
// 1,1 = 1 / 1,2 = 2 / 1,3 =4...

// 12 => 1+2+3+4 + 2 => 2,4