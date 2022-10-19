package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_2941_크로아티아알파벳_S5_박지호_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

//		Queue<Character> queue = new LinkedList<Character>();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < line.length(); i++) {
			stack.push(line.charAt(i));

		}

		int result = 0;
		while (!stack.isEmpty()) {
			char temp = stack.pop();

			switch (temp) {
			case '=':
				char case_temp = stack.pop();
				if (case_temp == 'z' && !stack.isEmpty()) {
					char z_temp = stack.pop();
					if (z_temp != 'd') {
						stack.push(z_temp);
					}
				}
				result++;
				break;
			case '-':
				stack.pop();
				result++;
				break; 
			case 'j':
				if (!stack.isEmpty()) {
					if(stack.peek() == 'l' || stack.peek() == 'n') {
						stack.pop();
					}
				}
				result++;
				break;

			default:
				result++;
				break;

			}

		}

		System.out.println(result);
	}
}
