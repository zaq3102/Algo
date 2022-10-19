package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import practice.test;

public class Solution_SWEA_7087_문제제목붙이기_D3_박지호_104ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Character> pQueue = new PriorityQueue<Character>();

			for (int i = 0; i < N; i++) {
				pQueue.offer(br.readLine().charAt(0));
			}

			int answer = 0;
			int idx = 0;
			while (!pQueue.isEmpty()) {
				char temp = pQueue.poll();

				if (ABC.charAt(idx++) == temp) {
					answer++;
					while (true) {
						if (!pQueue.isEmpty() && temp == pQueue.peek()) {
							pQueue.poll();
						} else {
							break;
						}
					}
				} else {
					break;
				}

			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
