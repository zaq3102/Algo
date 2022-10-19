package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_S1_박지호_같이품 {
	static char[][] m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N은 2의 제곱수, 1<=N<=64
		m = new char[N][]; // [N][N] 처럼 적을 경우 N칸 만들어놓고 아래에서 toCharArray 할때 칸을 또 만드므로 낭비 => 안쓰는게 빠르고 효율적
		for (int i = 0; i < N; i++) {
			m[i] = br.readLine().toCharArray(); // '11110000'
		}
		System.out.println(go(0, 0, N));

	}

	/**
	 * 정사각 영역의 시작좌표 : (sr,sc) 정사각 영역의 한 변의 크기 : size 정사각 영역을 문자열로 리턴하는 메서드
	 */
	public static String go(int sr, int sc, int size) {
		// 정사각 영역이 같은 값이라면, 그 숫자를 리턴
		int same = isSame(sr, sc, size);
		if (same == '0' || same == '1') {
			return same - '0' + ""; // + "" 해주면 스트링 타입으로 바꿔주는 효과
		}

		// 같은 값이 아니라면 (좌상, 우상, 좌하, 우하)
		int nextSize = size >> 1;
		return new StringBuilder().append("(").append(go(sr, sc, nextSize)) // >>1 는 나누기2한 효과가 있다 = 비트연산자
				.append(go(sr, sc + nextSize, nextSize)).append(go(sr + nextSize, sc, nextSize))
				.append(go(sr + nextSize, sc + nextSize, nextSize)).append(")").toString();

	}

	/**
	 * 정사각 영역의 시작좌표 : (sr,sc) 정사각 영역의 한 변의 크기 : size 정사각 영역을 문자열로 리턴하는 메서드 정사각 영역의
	 * 값이 모두 동일한지 체크하는 메서드 리턴 0, 1, -1(모두 동일하지 않을 때)
	 */
	public static int isSame(int sr, int sc, int size) {
		char t = m[sr][sc];

		for (int r = sr, er = sr + size; r < er; r++) {
			for (int c = sc, ec = sc + size; c < ec; c++) {
				if (t != m[r][c])
					return -1;

			}
		}

		return t;

	}
}
