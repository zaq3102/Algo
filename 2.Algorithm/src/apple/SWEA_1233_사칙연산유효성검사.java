package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {

	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = 10;

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N + 1];

			int answer = 1;

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();

				char temp = st.nextToken().charAt(0);

				if (st.hasMoreTokens()) { // 입력값이남아있다 = 단말노드가아니다
					if (temp >= '0' && temp <= '9') { // 숫자의 범위인가
						answer = 0;
					}

				} else { // 숫자라면 == 단말노드라면
					if (temp < '0' || temp > '9') {
						answer = 0;
					}

				}

			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

		}
		System.out.println(sb);

	}

}

// 편법인거 같으나 돌아가긴 한다