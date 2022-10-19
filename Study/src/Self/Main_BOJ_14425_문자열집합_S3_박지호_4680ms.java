package Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14425_문자열집합_S3_박지호_4680ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;

		String[] arr_N = new String[N];
		String[] arr_M = new String[M];

		for (int i = 0; i < N; i++) {
			arr_N[i] = br.readLine();
		}
		for (int i = 0; i < M; i++) {
			arr_M[i] = br.readLine();
		}

		for (int i = 0; i < arr_M.length; i++) {
			String temp = arr_M[i];

			for (int j = 0; j < arr_N.length; j++) {
				if (arr_N[j].equals(temp)) {
					System.out.println(temp);
					result++;
					break;
				}
			}

		}

		System.out.println(result);

	}
}
