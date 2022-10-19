package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울 {

	private static boolean[] isSelected;
	private static int N, Q;
	private static int[] chu;
	private static int[] rest;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			isSelected = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			chu = new int[N];
			rest = new int[N];
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
			}

			permutation(0);

			sb.append("\n");
		}

	}

	// 현재 자리에 수 뽑기
	public static void permutation(int cnt) { // cnt : 직전까지 뽑은 수 개수

		// 기본파트
		if (cnt == N) {
			go(1); // 0번지는 무조건 왼쪽이므로
//			System.out.println(Arrays.toString(rest));
			return;
		}

		// 입력받은 모든 수를 현재 자리에 넣어보기
		for (int i = 0; i < N; i++) {
			// 기존자리의 수들과 중복되는지 체크
			if (isSelected[i])
				continue;

			rest[cnt] = chu[i];
			isSelected[i] = true;
			// 다음수 뽑으러 가기

			permutation(cnt + 1);
			isSelected[i] = false;

		}

	}

	public static void go(int cnt2) { // 뒤부터 오른쪽 인덱스 넘겨가며 비교
		// 초기 cnt2 : 배열의 가장 마지막 인덱스

		if (cnt2 == N-1) { // 마지막 원소까지 부분집합에 다 고려된 상황
			System.out.println(Arrays.toString(rest));
//			for (int j = 0; j < N; j++) {
//				
////					System.out.print((!isSelected[j] ? rest[j] : "X") + " ");
//			}
			System.out.println();
			return;
		}

		// 현재 원소를 선택
		isSelected[cnt2] = false;
		go(cnt2 + 1);
//		System.out.println("1현재 cnt2 : " + cnt2);
		// 현재 원소를 비선택
		isSelected[cnt2] = true;
		go(cnt2 + 1);
//		System.out.println("2현재 cnt2 : " + cnt2);
	}

}

// 왼쪽 > 오른쪽 항상 성립해야한다
// 인덱스를 홀짝으로 구분해서 순열로 푼다...?
// 부분집합 후 순열 을 거친다?

// 첫 무게추는 무조건 왼쪽에
// 추를 왼쪽에 넣는 경우 N가지를 for문을 통해 메인에서 구현시키고
// for 문 안에서 나머지 요소들을 가지고 부분집합 계산
// 부분집합 결과를 순열로...?

// 왼쪽에 N개 반복문으로 돌려가면서
// 오른쪽에는 많아봐야 5개 => 오른쪽에 들어갈 추의 수를 0~R개까지 포문으로 돌린다?

// 왼쪽에 다넣어놓은 상황부터 시작
// 뒤부터 오른쪽 인덱스로 넘겨가며 비교
