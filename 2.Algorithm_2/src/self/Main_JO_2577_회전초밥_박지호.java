package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int result = 0;
		boolean max_containC = false;

		Queue<Integer> belt = new LinkedList<Integer>();
		Queue<Integer> eat = new LinkedList<Integer>();
		int[] sushi = new int[d + 1];

		for (int i = 0; i < N; i++) {
			belt.offer(Integer.parseInt(br.readLine()));
		}

		for (int i = 0; i < k; i++) {
			int temp = belt.poll();
			if (sushi[temp] == 0) { // 초면인 스시
				result++;
			}
			sushi[temp]++;
			eat.offer(temp);
		} // 초기 eat 배열에 스시를 넣어줬다

		int max = result;
		int cnt = 0;
		while (cnt < N) {
			cnt++;
			if (result == k && sushi[c] == 0) {
				max = result + 1;
				break;
			}

			int temp = eat.poll();
			sushi[temp]--;
			if (sushi[temp] == 0) {
				result--;
			}
			belt.offer(temp);

			int temp2 = belt.poll();
			if (sushi[temp2] == 0) {
				result++;
			}
			sushi[temp2]++;
			eat.offer(temp2);

			max = max > result ? max : result;

			if (max < result) {
				max = result;
				if (sushi[c] > 0) {
					max_containC = true;
				} else {
					max_containC = false;
				}
			}

		}

		if (max < k) {
			if (max_containC) {
				System.out.println(max);
			} else {
				System.out.println(max + 1);
			}

		} else {
			System.out.println(max);
		}
	}
}

// 벨트 큐 
// 먹을 초밥 큐 나눠서 사용
// 먹을초밥큐의 길이는 항상 k 유지
// visited 배열을 사용은 하지만 visitCnt 같이 들고다닌다 => visited 배열 전체탐색XXXXX
