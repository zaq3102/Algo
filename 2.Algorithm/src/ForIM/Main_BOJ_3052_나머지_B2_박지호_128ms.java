package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_3052_나머지_B2_박지호_128ms {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] result = new int[10];
		result[0] = Integer.parseInt(br.readLine()) % 42;
		int answer = 0;
		boolean isZero = false;

		for (int i = 1; i < 10; i++) {
			boolean flag = true;
			int temp = Integer.parseInt(br.readLine()) % 42;
			if (temp == 0) {
				isZero = true;
			}

			for (int j = 0; j < i; j++) {
				if (temp == result[j]) {
					flag = false;
				}
			}
			if (flag) {

				result[i] = temp;
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				answer++;
			}
		}
		if (isZero)
			answer++;

		System.out.println(answer);
	}
}
