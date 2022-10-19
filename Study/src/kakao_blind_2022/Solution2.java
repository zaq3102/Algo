package kakao_blind_2022;

import java.util.Stack;

public class Solution2 {
	static boolean[] prime = new boolean[121];

	public static void main(String[] args) {

	}

	public int solution(int n, int k) {

		Stack<Integer> stack = new Stack<Integer>();
		while (n >= k) {
			stack.push(n % k);
			n /= k;
		}
		stack.push(n);

//		String[] arr = new String[stack.size()]; // k진수 배열
		String arr = "";
		for (int i = 0, s = stack.size(); i < s; i++) {
			arr += stack.pop().toString();
		}

		int size = 1;
		while (size <= arr.length()) {

			for (int i = 0; i <= arr.length() - size; i++) {
				int temp = Integer.parseInt(arr.substring(i, size));

				if (temp == 1)
					continue;
				else if (temp == 2) {
					check(temp);
				} else if (temp % 2 == 0)
					continue;

				if (checkSosu(temp)) { // temp가 소수라면
					check(temp);
				}

			}

			size++;
		}

		int answer = -1;
		return answer;
	}

	public static boolean checkSosu(int temp) {
		boolean flag = true;

		for (int i = 3; i <= Math.sqrt(temp); i += 2) {
			if (temp % i == 0) { // 소수가 아니라면
				flag = false;
			}
		}
		return flag;
	}
	
	public static void check(int temp) {
		// 조건 맞추기
	}

}

// 일단 n진수로 변환하고
// 1자리 2자리 ,,, 끝자리 까지 소수인지 확인 후
// 아래 조건에 맞는 소수를 찾는다

// 0P0처럼 소수 양쪽에 0이 있는 경우
// P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
// 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
// P처럼 소수 양쪽에 아무것도 없는 경우
// 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
// 예를 들어, 101은 P가 될 수 없습니다.
