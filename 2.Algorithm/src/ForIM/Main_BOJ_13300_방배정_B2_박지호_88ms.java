package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_13300_방배정_B2_박지호_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int result = 0;
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 방 최대 수용 인원수
		int[][] info = new int[7][2];

		// 남자 1 여자 0 학년
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			info[grade][sex]++;

		}

//		System.out.println(Arrays.toString(info[5]));

		for (int i = 1; i <= 6; i++) {
			if (info[i][0] % K != 0) {
				result += info[i][0] / K + 1;
			} else if (info[i][0] != 0) {
				result += info[i][0]/K;
			}

			if (info[i][1] % K != 0) {
				result += info[i][1] / K + 1;
			} else if (info[i][1] != 0) {
				result += info[i][1]/K;
			}

		}
		System.out.println(result);
	}
}
