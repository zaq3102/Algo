package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_박지호 {

	static int[] parents;

	// 단위집합 생성
	public static void makeSet(int N) {
		parents = new int[N + 1];
		// 자신의 부모 노드를 자신의 값으로 세팅
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

	}

	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}

		return parents[a] = findSet(parents[a]); // path compression

	}

	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) { // 루트가 같으면 같은 집합 => union 불가
			return false;
		}

		parents[bRoot] = aRoot; // b집합의 대표자의 부모를 a집합의 대표자로
		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산 개수
			sb.append("#").append(testCase).append(" ");

			makeSet(n);

			for (int i = 0; i < m; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

				int k = Integer.parseInt(st2.nextToken());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());

				if (k == 1) { // 같은지 확인
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else { // 합집합
					union(a, b);
				}

			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

}

// 합집합은 0 a b 형태
// 같은지확인 1 a b 형태
