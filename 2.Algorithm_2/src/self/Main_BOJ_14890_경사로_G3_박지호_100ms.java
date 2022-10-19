package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14890_경사로_G3_박지호_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = 1;

		for (int testCase = 1; testCase <= TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 지도 한 변 크기
			int X = Integer.parseInt(st.nextToken()); // 경사로 길이
			int result = 0;

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				int cnt = 1;
				int temp = map[i][0];
				boolean flag = true;
				boolean isFall = false;

				for (int j = 1; j < N; j++) {
					if (temp == map[i][j]) {
						cnt++;
					} else {
						if (Math.abs(temp - map[i][j]) > 1) {
							flag = false;
							break;
						}
						if (temp > map[i][j]) { // 현재가 더 낮은 경우 = 내리막길
							isFall = true;
							int lowtemp = map[i][j];
							int idx = j;
							int lowcnt = 1;
							while (true) {
								if (idx == N - 1) {
									if (lowcnt < X) {
										flag = false;
									}
									break;
								}

								if (lowtemp == map[i][idx + 1]) {
									lowcnt++;
									idx++;
								} else {
									break;
								}
							}
							// 한 층 아래 시작부터 몇칸까지 같은 높이로 유지되는가 = lowcnt

							if (lowcnt < X) {
								flag = false;
								break;
							}
							j = idx;
							temp = map[i][j];
							cnt = lowcnt;

						} else { // 현재가 더 높은 경우 = 오르막길
							if (cnt < X) {
								flag = false;
								break;
							}

							if (isFall && cnt < X * 2) {
								flag = false;
								break;
							}
							isFall = false;
							temp = map[i][j];
							cnt = 1;
						}
					}
				}
				if (flag) {
					result++;
				}
			}

			for (int i = 0; i < N; i++) {
				int cnt = 1;
				int temp = map[0][i];
				boolean flag = true;
				boolean isFall = false;

				for (int j = 1; j < N; j++) {
					if (temp == map[j][i]) {
						cnt++;
					} else {
						if (Math.abs(temp - map[j][i]) > 1) {
							flag = false;
							break;
						}
						if (temp > map[j][i]) { // 현재가 더 낮은 경우 = 내리막길
							isFall = true;
							int lowtemp = map[j][i];
							int idx = j;
							int lowcnt = 1;
							while (true) {
								if (idx == N - 1) {
									if (lowcnt < X) {
										flag = false;
									}
									break;
								}

								if (lowtemp == map[idx + 1][i]) {
									lowcnt++;
									idx++;
								} else {
									break;
								}
							}

							if (lowcnt < X) {
								flag = false;
								break;
							}
							j = idx;
							temp = map[j][i];
							cnt = lowcnt;
						} else { // 현재가 더 높은 경우 = 오르막길
							if (cnt < X) {
								flag = false;
								break;
							}

							if (isFall && cnt < X * 2) {
								flag = false;
								break;
							}
							isFall = false;
							temp = map[j][i];
							cnt = 1;
						}
					}
				}
				if (flag) {
					result++;
				}
			}
			sb.append(result);

		} // end of TC
		System.out.println(sb);

	}
}

// 가로나 세로 한 줄을 대상으로 조건 통과하는지 본다
// 각 행의 0번 인덱스를 기준으로 잡고 같은 높이일 때마다 카운트 세준다
// 높이가 높아지면 => 지금까지 세준 카운트가 X이상인지 판별한 다음 카운트를 0으로 초기화
// 높이가 낮아지면 => 낮아진 셀부터 카운트를 초기화 하여 카운트세준다 
// 인덱스가 N-1에 도달했을 때 flag 가 true일 경우 활주로 건설 가능

// 같은 높이에서 경사로를 2개 놓는 경우도 생각봐야된다
