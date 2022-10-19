package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<String> deck = new LinkedList<String>();
			Queue<String> A = new LinkedList<String>(); // 먼저뽑는다
			Queue<String> B = new LinkedList<String>();

			for (int i = 0; i < N; i++) { // 초기 덱 저장
				deck.offer(st.nextToken());
			}

			if (N % 2 != 0) {
				A.offer(deck.poll());
			}
			for (int i = 0; i < N / 2; i++) { // 덱을 A와 B로 분리
				A.offer(deck.poll());
			}
			for (int i = 0; i < N / 2; i++) { // 덱을 A와 B로 분리

				B.offer(deck.poll());
			}

			for (int i = 0; i < N / 2; i++) { // 원래 덱으로 퍼펙트 셔플 실행 + sb에 출력값 동시 저장
				sb.append(A.peek()).append(" ");
				deck.offer(A.poll());
				sb.append(B.peek()).append(" ");
				deck.offer(B.poll());
			}

			if (A.size() != 0) { // N이 홀수라 A에 원소가 남아있다면
				sb.append(A.peek()).append(" ");
				deck.offer(A.poll());
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}

// 길이 N의 큐에 초기 전체 덱 저장
// 전체길이/2  + 1 만큼 큐 A에 나머지를 큐 B에 저장
