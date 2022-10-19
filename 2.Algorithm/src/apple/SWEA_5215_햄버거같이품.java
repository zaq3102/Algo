package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 입력의 최적화 Scanner => BufferedReader 쪼개는 방법 String.split(정규화표현식) =>
 * StringTokenizer
 *
 */

public class SWEA_5215_햄버거같이품 {

	public static int N;
	public static int maxT;
	public static int L;
	public static int[][] v;

	/**
	 * i : 단계, sumT : 맛의 현재 단계까지의 합, sumK : 칼로리의 현재 단계까지의 합 현재까지 계산한 결과를 매번 가지고 다니자
	 */
	public static void dfs(int i, int sumT, int sumK) {
		if (i == N) {
			// 선택한 재료들의 맛의 총합, 칼로리의 총합을 구해서 칼로리 제한 범위 이내에서 최대 맛 찾기
			if (sumK <= L && maxT < sumT) {
				maxT = sumT;
			}
		} else if (sumK <= L) {
			// 선택 함
			dfs(i + 1, sumT + v[i][0], sumK + v[i][1]);

			// 선택 안함
			dfs(i + 1, sumT, sumK);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // split보다 효율적이다
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리 10^4
			v = new int[N][2]; // 1차원배열 두개 쓰는게 참조수 비교하면 효율적일수도
			maxT = 0;

			for (int i = 0; i < N; i++) { // 맛 정보 저장
				st = new StringTokenizer(br.readLine(), " "); // split보다 효율적이다
				v[i][0] = Integer.parseInt(st.nextToken());// 맛
				v[i][1] = Integer.parseInt(st.nextToken());// 칼로리
			}
			dfs(0, 0, 0); // 깊이우선으로 탐색
			sb.append("#").append(testCase).append(" ").append(maxT).append("\n");
		}
		System.out.println(sb.toString());
	}

}
