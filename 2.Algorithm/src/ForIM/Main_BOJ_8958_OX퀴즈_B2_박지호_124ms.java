package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_8958_OX퀴즈_B2_박지호_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String line = br.readLine();

			int cnt = 1;
			int answer = 0;
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == 'O') {
					answer += cnt++;
				} else {
					cnt = 1;
				}

			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}
}
