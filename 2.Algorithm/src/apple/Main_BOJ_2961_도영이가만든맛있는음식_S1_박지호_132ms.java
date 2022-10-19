package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식_S1_박지호_132ms {

	static boolean[] isSelected;
	static int[][] ingre;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ingre = new int[N][2];
		isSelected = new boolean[N];
		// 부분집합 찾기 이전에 재료의 값을 받아준다

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingre[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			ingre[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		min = Integer.MAX_VALUE;
		generateSubset(0);
		System.out.println(min);
	}

	public static void generateSubset(int cnt) { // 부분집합에 고려해야 하는 원소 = 직전까지 고려한 원소 수
		if (cnt == ingre.length) { // 마지막 원소까지 부분집합에 다 고려된 상황
			int sour = 1; // 곱이므로 초기값은 1
			int bitter = 0; // 합이므로 초기값은 0
			int count = 0;
			for (int i = 0; i < isSelected.length; i++) {
				if (isSelected[i]) { // 부분집합에 속한 원소라면
					count++;
					sour *= ingre[i][0];
					bitter += ingre[i][1];
				}
			}

			if (count == 0)
				return; // 공집합이면 리턴
			if (min > Math.abs(sour - bitter))
				min = Math.abs(sour - bitter);
			return;
		}

		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}

}

// 신맛 = 사용 재료의 신맛의 곱 / 쓴맛 = 사용 재료의 쓴맛의 합
// 최소 1개이상 재료 사용 / 쓴맛과 신맛의 차이가 작도록
// 부분집합으로 푼다