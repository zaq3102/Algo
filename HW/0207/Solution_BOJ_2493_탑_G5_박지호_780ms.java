package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_G5_박지호_780ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> top = new Stack<>();
		Stack<Integer> receive = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken()); 
			if (top.isEmpty()) { // 빈 스택일 경우
				sb.append("0 "); 
				top.push(n); 
				receive.push(i); 
			} else { // 아닐 경우
				while (true) { 
					if (top.isEmpty()) { // 빈 스택이거나
						sb.append("0 ");
						top.push(n);
						receive.push(i);
						break; 
					}
					if (top.peek() > n) { // 앞의 탑이 작을때 까지 while 반복문 사용
						sb.append(receive.peek()).append(" ");
						top.push(n); 
						receive.push(i); 
						break;
					} else { // 걸리지 않는 탑을 제거한다
						top.pop(); 
						receive.pop();
					}
				}
			}
		}
		System.out.println(sb);
		br.close();

	}
}

// 탑의 입력배열을 앞에서 부터 하나씩 비교한다
// 탑의 값과 자리값을 각각의 스택에 넣어서 비교하며
// 탑이 걸릴때까지 while문을 반복하는 것이 포인트
// 걸리지 않는 탑은 pop을 통해 제거한다
