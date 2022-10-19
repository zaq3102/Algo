package kakao_blind_2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_다트게임 {
	public static void main(String[] args) {

		String dartResult = "1T2D3D#";

		System.out.println(solution(dartResult));

	}

	public static int solution(String dartResult) {

		Queue<Character> queue = new LinkedList<Character>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < dartResult.length(); i++) {
			char temp = dartResult.charAt(i);

			if (temp == 'S') {
				String snum = "";
				while (!queue.isEmpty()) {
					snum += queue.poll();
				}

				int num = Integer.parseInt(snum);
				stack.push(num);

			} else if (temp == 'D') {
				String snum = "";
				while (!queue.isEmpty()) {
					snum += queue.poll();
				}

				int num = Integer.parseInt(snum);
				stack.push(num * num);

			} else if (temp == 'T') {
				String snum = "";
				while (!queue.isEmpty()) {
					snum += queue.poll();
				}

				int num = Integer.parseInt(snum);
				stack.push(num * num * num);
			} else if (temp == '*') {
				if (!stack.isEmpty()) {
					int sec = stack.pop();
					if (!stack.isEmpty()) {
						int fir = stack.pop();
						stack.push(fir * 2);
					}
					stack.push(sec * 2);
				}

			} else if (temp == '#') {
				if (!stack.isEmpty()) {
					stack.push(stack.pop() * (-1));
				}

			} else { // 숫자일경우
				queue.offer(temp);
			}

		}

		int answer = 0;

		while (!stack.isEmpty()) {
			answer += stack.pop();
		}

		return answer;
	}
}

// 점수는 스택에
// 연산과정은 큐에