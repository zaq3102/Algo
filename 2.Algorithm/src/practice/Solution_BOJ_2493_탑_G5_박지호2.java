package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_G5_박지호2 {

	static Stack<Integer> top;
	static Stack<Integer> receive;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		cnt = 0;

		top = new Stack<>();
		receive = new Stack<>();

		for (int i = 0; i < N; i++) {
			top.push(Integer.parseInt(st.nextToken()));
		}

		int stand = top.pop();
		int move = 0;

		for (int i = N - 1; i > 0; i--) {
			move = top.peek();
			if (stand > move) {
				cnt++;
			} else {

				while (cnt >= 0) {
					receive.push(i);
					cnt--;
				}

				cnt = 0;
				stand = move;
			}
			if (top.size() == 0 && cnt > 0) {
				for (int j = 0; j < cnt; j++) {
					receive.push(0);
				}
			}
		}

		receive.push(0); // 1번째 탑은 항상 수신x
		for (int i = 0; i < N - 1; i++) {
			sb.append(receive.pop()).append(" ");
		}
		sb.append(receive.pop());
		System.out.println(sb.toString());

	}
}

//top에서 pop을 한다
//기준탑 보다 큰 탑 나오면 스택길이만큼 배열에 값 저장
//기준탑 보다 작은 탑 나오면 카운트 올려주고 pop