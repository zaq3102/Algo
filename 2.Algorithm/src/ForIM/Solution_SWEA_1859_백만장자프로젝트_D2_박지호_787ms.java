package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2_박지호_787ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		Stack<Long> stack = null;
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			long answer = 0;
			int N = Integer.parseInt(br.readLine());
			stack = new Stack<Long>();
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				stack.push(Long.parseLong(st.nextToken()));
			}

			long max = stack.pop();
			while (!stack.isEmpty()) {
				long temp = stack.pop();

				if (temp > max) {
					max = temp;
				} else {
					answer += max - temp;
				}

			}

			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}

// 뒤에서 부터 생각하자
// 뒤에서부터 하나씩 보면서 제일 처음 뽑은 수를 max값으로 설정
// 다음 값이 더 크면 max갱신 / 더 작으면 차이만큼 결과에 ++
