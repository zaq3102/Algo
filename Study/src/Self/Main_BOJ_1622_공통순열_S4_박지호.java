package Self;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1622_공통순열_S4_박지호 {
	private int[] getCntArr(String s) {
		int[] cnt = new int['z' - 'a' + 1];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		return cnt;
	}

	private void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			String a = br.readLine();
			if (a == null)
				break;
			String b = br.readLine();

			int[] cntA = getCntArr(a);
			int[] cntB = getCntArr(b);

			for (int i = 0; i < cntA.length; i++) {
				for (int j = 0; j < Math.min(cntA[i], cntB[i]); j++) {
					answer.append((char) ('a' + i));
				}
			}
			answer.append('\n');
		}
		System.out.print(answer);
	}

	public static void main(String[] args) throws Exception {
		new Main_BOJ_1622_공통순열_S4_박지호().solution();
	}
}
