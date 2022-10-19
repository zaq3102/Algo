package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀함수 분할정복 작성 시간이 터질 가능성이 높다 => 예상할 수 있는 부분의 재귀호출은 생략하자
 */
public class Main_BOJ_1074_Z_박지호_같이품 {
	static int r, c;
	static int answer = 0;
	static int[] bin = { 1, 2, 4, 8, 16, 32, 64, 128 };
	// bin 배열 사용하여 작업 간소화 => hashing

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 2차원배열 크기 2^N * 2^N / 1<= N <= 15
		r = Integer.parseInt(st.nextToken()); // 행 0 <= r,c <= 2^N
		c = Integer.parseInt(st.nextToken()); // 열

		go(N, 0, 0);
	}

	/**
	 * 사각형의 가로세로 크기 = 2^N, 사각형의 시작 위치(sr, sc)
	 */
	public static void go(int n, int sr, int sc) {
		// 예상 할 수 있는 부분의 재귀호출은 생략하자 : 사각영역에 r,c가 포함되지 않으면 계산만 하고 넘어가자
		if (r < sr || sr + bin[n] <= r || c < sc || sc + bin[n] <= c) { // 사각영역 밖이면
			answer += bin[n] * bin[n];
			return;
		}
		if (n == 0) {
			if (sr == r && sc == c) {
				System.out.println(answer);
				System.exit(0); // 프로그램 종료
			}
			answer++;
			return;
		}

		go(n - 1, sr, sc); // 좌상
		go(n - 1, sr, sc + bin[n - 1]); // 우상
		go(n - 1, sr + bin[n - 1], sc); // 좌하
		go(n - 1, sr + bin[n - 1], sc + bin[n - 1]); // 우하
	}
// (int)Math.pow(2,n) => 2^N 반복문으로 구현 => 2^N 분할정복으로 구현 => 1<< 비트연산 => hashing
//	public static int mypow(int ex) {
//		int result = 1;
//		for (int i = 0; i < ex; i++) {
//			result *= 2;
//		}
//
//		return result;
//	}
}

//분할정복
//x랑 y 좌표에서 r,c를 찾을때까지 반으로 나누고 나누고 해야한다