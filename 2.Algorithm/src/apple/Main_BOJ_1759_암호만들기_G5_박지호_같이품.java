package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시뮬레이션, 백트래킹, 조합 아이디어 : 자음 모음 판단 여부를 입력 후 정렬 시 미리 조사해두자, 해싱기법 재귀함수 : 선택된 모음,
 * 자음의 개수를 들고다니자
 */
public class Main_BOJ_1759_암호만들기_G5_박지호_같이품 {

	private static StringBuilder sb;
	private static int L, C;
	private static char[] c;
	private static char[] pass;
	private static int[] moeum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		c = new char[C]; // 입력된 문자 저장
		String str = br.readLine();
		for (int i = 0, index = 0; i < c.length; i++, index += 2) {
			c[i] = str.charAt(index);
		}
		Arrays.sort(c);
		// a b c d e f g h i j k l m n o p q r s t u v w x y z
		int[] alpaMoeum = { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 };
		moeum = new int[C];
		for (int i = 0; i < c.length; i++) {
			moeum[i] = alpaMoeum[c[i] - 'a'];
		}
		sb = new StringBuilder();
		pass = new char[L];
		comb(0, 0, 0, 0);
		System.out.println(sb);
	}

	/**
	 * 조합 재귀함수, index : 현재 선택할 원소 위치, start : 다음 선택시작위치, ja : 자음개수, mo : 모음개수
	 */
	public static void comb(int index, int start, int ja, int mo) {
		if (index == L) { // 종료 파트
			if (ja >= 2 && mo >= 1) {// 최소 모음 1개, 자음 2개로 구성되어야함
				sb.append(pass).append("\n");
			}
			return;
		}

		// 재귀 파트
		for (int i = start; i < c.length; i++) {
			pass[index] = c[i];
			comb(index + 1, i + 1, ja + (1 - moeum[i]), mo + moeum[i]);
		}

	}

}

// 최소 한 개 모음, 최소 두 개 자음
// 오름차순
// 암호길이 L 문자종류 수 C

// 조합

// a b c d ... => 전체 스트링으로 받아서 charAt 하는 것도 아이디어