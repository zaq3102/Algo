package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		int[][] pan = new int[12][12];

		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 총이동시간
			int A = Integer.parseInt(st.nextToken()); // BC 수
			Queue<Integer> moveA = new LinkedList<Integer>(); // A의 이동정보
			Queue<Integer> moveB = new LinkedList<Integer>(); // B의 이동정보

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA.offer(Integer.parseInt(st2.nextToken()));
				moveB.offer(Integer.parseInt(st3.nextToken()));
			}

			for (int i = 0; i < A; i++) {
				StringTokenizer st4 = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st4.nextToken()); // BC가로
				int y = Integer.parseInt(st4.nextToken()); // BC세로
				int C = Integer.parseInt(st4.nextToken()); // 충전범위
				int P = Integer.parseInt(st4.nextToken()); // 충전량

				int area = y - C, mid = x;
				for (int k1 = x - C; k1 <= x + C; k1++) {
					int start = mid - area;
					int end = mid + area;

					for (int k2 = start; k2 <= end; ++k2) {
						if(k1 >= 1 && k1 <= 10 && k2 >= 1 && k2 <= 10) {
							pan[k1][k2] += 1;
						}
					}

					if (k1 >= mid) {
						area--;
					} else {
						area++;
					}

				}

			}

			for (int i = 0; i < pan.length; i++) {
				for (int j = 0; j < pan.length; j++) {
					System.out.print(pan[i][j] + " ");
				}
				System.out.println();
			}

		}

	}
}

// 총 T개의 테케
// 총 이동시간 M BC개수 A
// A이동정보 B이동정보 => 이동X0 상우하좌 1234
// 이후 A개만큼의 BC정보 => 가로,세로, 충전범위, 충전량

// 전체 BC 정보를 10x10맵에 저장
// 이동정보 큐로 받아서 하나씩 뽑아씀
// A시작지점1,1 B시작지점 10,10을 시작으로 큐에 정보 따라 좌표 이동
// 시간은 0초부터 M초까지 잰다 => 처음 시작자리부터 충전량 계산 후 움직인다
// 매 시간마다 isBC 배열에 T F 체크함
// BC 체크 후 충전량 계산 메서드로 넘김
// 서로의 isBC체크해서 겹치는 BC일 경우 서로 다른

// 영역을 맵에 표시할 필요 x
// 어차피 중심부 좌표 아니까 거리만 계산해서 조건문에 넣어주면 된다 => 수동적이라 시간이 많이 걸림

