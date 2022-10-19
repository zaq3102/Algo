package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2999_비밀이메일_B1_박지호_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String msg = br.readLine();
		int N = msg.length();
		int R = 0;
		int C = 0;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				queue.offer(i);
			}
		}

		int size = queue.size();
		if (size % 2 == 1) {

			for (int i = 0; i < size / 2; i++) {
				queue.poll();
			}
			R = C = queue.poll();
		} else {

			for (int i = 0; i < size; i++) {
				if (i + 1 == size / 2) {
					R = queue.poll();
					C = queue.poll();
					break;
				}
				queue.poll();
			}
		}

//		System.out.println("R : " + R + " C : " + C);
		char[][] letter = new char[R][C];
		int idx = 0;

		ex: for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (idx == N) {
					break ex;
				}
				letter[j][i] = msg.charAt(idx++);
			}
		}

//		for (int i = 0; i < C; i++) {
//			for (int j = 0; j < R; j++) {
//				sb.append(letter[j][i]);
//			}
//		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(letter[i][j]);
			}
		}
		

		System.out.println(sb);
	}
}

// 메세지 글자 N
// R <= C and R*C = N => 성립경우가 여러가지일 경우 R이 큰 값 선택
// 행 R 열 C
// 가로로 배열에 순차적으로 넣어서
// 세로로 읽어낸다