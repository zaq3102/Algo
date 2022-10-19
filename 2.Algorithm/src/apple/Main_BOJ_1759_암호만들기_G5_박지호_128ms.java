package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기_G5_박지호_128ms {
	private static int L, C;
	private static char[] alpha;
	private static char[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		result = new char[L];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = st2.nextToken().charAt(0);
		}

		Arrays.sort(alpha);
		combi(0, 0);
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static void combi(int cnt, int start) {
		if (cnt == L) {
			int odd = 0; // 모음
			int even = 0; // 자음

			for (int i = 0; i < result.length; i++) {
				char temp = result[i];
				if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
					odd++;
				} else {
					even++;
				}
			}

			if (odd >= 1 && even >= 2) {
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
				return;
			} else {
				return;
			}
		}

		for (int i = start; i < C; i++) {
			result[cnt] = alpha[i];
			combi(cnt + 1, i + 1);
		}

	}
}

// 최소 한 개 모음, 최소 두 개 자음
// 오름차순
// 암호길이 L 문자종류 수 C

// 조합

// a b c d ... => 전체 스트링으로 받아서 charAt 하는 것도 아이디어