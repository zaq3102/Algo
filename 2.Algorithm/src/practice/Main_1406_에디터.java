package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1406_에디터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> A = new LinkedList<Character>();
		String temp = br.readLine();

		for (int i = 0; i < temp.length(); i++) { // 초기값을 연결리스트로 만듬
			A.offer(temp.charAt(i));
		}

		int cursor_size = A.size() + 1; // 커서의 전체 크기를 고려하는 변수
		int cursor_idx = cursor_size - 1; // 커서의 위치를 나타내는 변수
		int orders = Integer.parseInt(br.readLine());

		for (int i = 0; i < orders; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if (st.countTokens() == 1) { // L D B
				switch (st.nextToken()) {
				case "L":
					if (cursor_idx == 0) {
						break;
					}
					cursor_idx--;
					break;
				case "D":
					if (cursor_idx == cursor_size - 1) {
						break;
					}
					cursor_idx++;
					break;
				case "B": // A의 cursor_idx - 1 번지 값을 없앤다
					if (cursor_idx == 0) {
						break;
					}
					A.remove(--cursor_idx);
					cursor_size--;
					break;
				}
			} else { // 무조건 P
				String gar = st.nextToken();
				String repl = st.nextToken(); // 대체되어 들어가는 문자

				// A의 cursor_idx번지에 추가
				if (cursor_idx == cursor_size - 1) {
					A.offer(repl.charAt(0));
					cursor_size++;
					cursor_idx++;
				} else {
					A.add(cursor_idx, repl.charAt(0));
					cursor_size++;
				}
			}
		}
		for (int i = 0; i < cursor_size - 1; i++) {
			sb.append(A.get(i));
		}
		System.out.println(sb);
	}
}

// A B C D  => 문자열
//0 0 0 0 0 => 커서
// L : 왼쪽옮김 / R : 오른쪽옮김 / B : 커서 왼쪽문자삭제 / P * : * 문자를 커서왼쪽에 추가
// 모두 양 끝이라면 무시
// 명령어 수 = M

// LinkedList를 이용한 구현 => 시간초과로 ListIterator를 사용해야 한다