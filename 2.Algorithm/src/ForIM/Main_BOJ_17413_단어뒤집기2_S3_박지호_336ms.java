package ForIM;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2_S3_박지호_336ms {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean isSealed = false;

		String line = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < line.length(); i++) {
			char temp = line.charAt(i);
			if (temp == '<') {
				while (!stack.isEmpty()) {
					queue.offer(stack.pop());
				}
				isSealed = true;
			}
			if (temp == '>') {
				queue.offer('>');
				isSealed = false;
				continue;
			}
			if (isSealed == false && temp == ' ') {
				while (!stack.isEmpty()) {
					queue.offer(stack.pop());
				}
				queue.offer(' ');
				continue;
			}

			if (isSealed) {
				queue.offer(temp);
			} else if (temp != '>') {
				stack.push(temp);

			}
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}

		if (queue.peek() == ' ') {
			queue.poll();
		}
		while (!queue.isEmpty()) {
			sb.append(queue.poll());
		}
		System.out.println(sb);
	}
}
