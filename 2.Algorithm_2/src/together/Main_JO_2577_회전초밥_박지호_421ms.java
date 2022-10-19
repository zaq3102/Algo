package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우 : 범위가 일정한 경우 투 포인터 : 범위가 일정하지 않은 경우 (범위의 시작위치, 끝 위치를 가리킬 포인터 두 개를
 * 움직이면서 범위 처리)
 *
 */

public class Main_JO_2577_회전초밥_박지호_421ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] chobab = new int[N];
		for (int i = 0; i < N; i++) {
			chobab[i] = Integer.parseInt(br.readLine());
		}

		int max = 0; // 서로 다른 초밥을 먹은 개수의 최대값
		int diff = 0; // 서로 다른 초밥을 먹은 개수
		int[] cnt = new int[d + 1]; // 각 숫자초ㅗ밥을 먹은 개수, 0번 초밥은 안씀

//		첫번째 턴을 초기값으로 작성
		for (int i = 0; i < k; i++) {
			if (cnt[chobab[i]] == 0) {
				diff++;
			}
			cnt[chobab[i]]++;
		}
		if (cnt[c] == 0) {
			diff++;
		}
		cnt[c]++;
		if (max < diff)
			max = diff;

//		슬라이딩 윈도우 : 1개 빼고 1개 추가
		for (int i = 0; i < N - 1; i++) { // i번째를 뺀다, insert = k+i+1 => 추가할 순번
			int insert = k + i;
			if (insert >= chobab.length) {
				insert = insert - N + 1;
			}
			if (cnt[chobab[i]] == 1) {
				diff--;
			}
			cnt[chobab[i]]--;

			if (cnt[chobab[i]] == 0) {
				diff++;
			}
			cnt[chobab[i]]++;
			if (max < diff)
				max = diff;

		}

		System.out.println(max);
	}
}

// 벨트 큐 
// 먹을 초밥 큐 나눠서 사용
// 먹을초밥큐의 길이는 항상 k 유지
// visited 배열을 사용은 하지만 visitCnt 같이 들고다닌다 => visited 배열 전체탐색XXXXX
