package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1158_요세푸스_S5_박지호_584ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		sb.append("<");
		for (int i = 1; i <= N; i++) { // 큐에 N까지의 배열 삽입
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
