package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_40212_요리사_박지호 {

	static boolean[] isSelected;
	static int N;
	static int[][] ingre;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			ingre = new int[N][N];

			for (int i = 0; i < N; i++) { // 재료 배열 생성
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					ingre[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			isSelected = new boolean[N];
			combination(N / 2, 0);
			System.out.println("#" + testCase + " " + min);
		}

	}

	public static void combination(int cnt, int start) {

		if (cnt == N) {
			int result = solve();
			min = min > result ? result : min; // 더 작은 값 넣어주기
			return;
		}

		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(cnt + 1, i + 1); // 다음자리는 현재 뽑은 i의 다음수부터 시작하도록 전달
			isSelected[i] = false;
		}
	}

	public static int solve() {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();

		// isSelected 배열을 통해 재료 분류
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				A.add(i);
			} else {
				B.add(i);
			}
		}

		int a = 0; // A 음식 시너지 합
		int b = 0; // B 음식 시너지 합

		for (int i = 0; i < A.size()-1; i++) {
			for (int j = i; j < A.size(); j++) {
				a += ingre[A.get(i)][A.get(j)];
				a += ingre[A.get(j)][A.get(i)];
				b += ingre[B.get(i)][B.get(j)];
				b += ingre[B.get(j)][B.get(i)];

			}
		}

		return Math.abs(a - b); // 맛의 차이 리턴
	}

}

// 
// 식재료 수 N
// 이후 1번째 식재료의 시너지 S11, S12... S1N 
// 2번째
// ... 해서 N번째까지

// nP2 를 사용해서 값 계산 계산값을 가지고 다시 n-2P2 수행

// 0번째일때 (0,1)+(1,0) / 0,2 2,0 / 0,3 3,0 ...

// 현재 자리에 수 뽑기
//	public static void permutation(int cnt) { // cnt : 직전까지 뽑은 수 개수
//
//		// 기본파트
//		if (cnt == 2) {
//			
//			
//			System.out.println(Arrays.toString(numbers));
//			return;
//		}
//
//		// 입력받은 모든 수를 현재 자리에 넣어보기
//		for (int i = 0; i < N; i++) {
//			// 기존자리의 수들과 중복되는지 체크
//			if (isSelected[i])
//				continue;
//
//			numbers[cnt] = input[i];
//			isSelected[i] = true;
//			// 다음수 뽑으러 가기
//
//			permutation(cnt + 1);
//			isSelected[i] = false;
//
//		}
//
//	}