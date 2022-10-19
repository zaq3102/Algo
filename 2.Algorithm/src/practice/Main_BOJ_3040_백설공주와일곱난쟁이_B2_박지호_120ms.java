package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_3040_백설공주와일곱난쟁이_B2_박지호_120ms {
	static int[] small;
	static int[] result;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		small = new int[9];
		for (int i = 0; i < 9; i++) {
			small[i] = Integer.parseInt(br.readLine());
		}
		result = new int[7];
		queue = new LinkedList<Integer>();
		combination(0, 0);

		for (int i = 0; i < result.length; i++) {
			System.out.println(queue.poll());
		}

	}

	public static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}

			if (sum == 100) {
				for (int i = 0; i < result.length; i++) {
					queue.offer(result[i]);
				}
			}

			return;
		}

		for (int i = start; i < 9; i++) {
			result[cnt] = small[i];
			combination(cnt + 1, i + 1); // 다음자리는 현재 뽑은 i의 다음수부터 시작하도록 전달
		}
	}

}
