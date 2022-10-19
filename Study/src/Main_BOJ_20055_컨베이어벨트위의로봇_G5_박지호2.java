import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇_G5_박지호2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] belt = new int[2][N];
		Queue<int[]> robot = new LinkedList<int[]>();
		boolean[][] visited = new boolean[2][N];

		int isZero = 0;
		int level = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				for (int j = 0; j < N; j++) {
					belt[i][j] = Integer.parseInt(st.nextToken());
				}
			} else {
				for (int j = N - 1; j > -1; j--) {
					belt[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		} // end of for

		while (true) {
			level++;
			
			// 1. 벨트 회전
			int up_last = belt[0][N - 1];
			int down_last = belt[1][0];
//			boolean up_last_check = visited[0][N - 1];
//			boolean down_last_check = visited[1][0];

			for (int tc = 0; tc < 2; tc++) {
				if (tc == 0) {
					for (int i = N - 1; i > 0; i--) {
						belt[tc][i] = belt[tc][i - 1];
						visited[tc][i] = visited[tc][i - 1];
					}
				} else {
					for (int i = 0; i < N - 1; i++) {
						belt[tc][i] = belt[tc][i + 1];
						visited[tc][i] = visited[tc][i + 1];
					}
				}

			}
			belt[1][N - 1] = down_last;
			belt[0][0] = up_last;
			visited[1][N - 1] = false;
			visited[0][0] = false;

			for (int i = 0, end = robot.size(); i < end; i++) { // 회전만 하는 것 (내구도 감소X)
				int[] temp = robot.poll();
				int beltNo = temp[0];
				int loc = temp[1];

				if (beltNo == 0 && loc == N - 1) { // 아래로 내려갈 로봇이라면
					robot.offer(new int[] { 1, N - 1 });
				} else if (beltNo == 1 && loc == 0) { // 위로 올라갈 로봇이라면
					robot.offer(new int[] { 0, 0 });
				} else if (beltNo == 0) { // 윗 밸트
					robot.offer(new int[] { 0, loc + 1 });
				} else { // 아랫 밸트
					robot.offer(new int[] { 1, loc - 1 });
				}

			}

			// 2. 로봇 움직이기
			boolean moved = false;
			if (robot.size() == 2 * N && isZero == 0) { // 모든 칸에 로봇이 있는데 움직일 수 있다면
				for (int i = 0; i < N; i++) {
					belt[0][i]--;
					if (belt[0][i] == 0) {
						isZero++;
					}
					belt[1][i]--;
					if (belt[1][i] == 0) {
						isZero++;
					}
				}

			} else if(robot.size() == 2 * N && isZero != 0) { // 모든 칸에 로봇이 있으나 움직일수 없다면
				
				break;
			}
			
			else {

				for (int i = 0, end = robot.size(); i < end; i++) { // 회전만 하는 것 (내구도 감소X)
					int[] temp = robot.poll();
					int beltNo = temp[0];
					int loc = temp[1];

					if (beltNo == 0 && loc == N - 1) { // 아래로 내려갈 로봇이라면
						if (belt[1][N - 1] != 0 && !visited[1][N - 1]) { // 갈 수 있는 조건이라면
							belt[1][N - 1]--;
							if (belt[1][N - 1] == 0) {
								isZero++;
							}
							visited[1][N - 1] = true;
							visited[beltNo][loc] = false;

							moved = true;
							robot.offer(new int[] { 1, N - 1 });
						} else { // 갈 조건이 안된다면
							robot.offer(temp);
						}
					} else if (beltNo == 1 && loc == 0) { // 위로 올라갈 로봇이라면
						if (belt[0][0] != 0 && !visited[0][0]) {
							belt[0][0]--;
							if (belt[0][0] == 0) {
								isZero++;
							}
							visited[0][0] = true;
							visited[beltNo][loc] = false;
							
							moved = true;
							robot.offer(new int[] { 0, 0 });
						} else { // 갈 조건이 안된다면
							robot.offer(temp);
						}
					} else if (beltNo == 0) { // 윗 밸트
						if (belt[0][loc + 1] != 0 && !visited[0][loc + 1]) {
							belt[0][loc + 1]--;
							if (belt[0][loc + 1] == 0) {
								isZero++;
							}
							visited[0][loc + 1] = true;
							visited[beltNo][loc] = false;

							moved = true;
							robot.offer(new int[] { 0, loc + 1 });
						} else { // 갈 조건이 안된다면
							robot.offer(temp);
						}

					} else { // 아랫 밸트
						if (belt[1][loc - 1] != 0 && !visited[1][loc - 1]) {
							belt[1][loc - 1]--;
							if (belt[1][loc - 1] == 0) {
								isZero++;
							}
							visited[1][loc - 1] = true;
							visited[beltNo][loc] = false;

							moved = true;
							robot.offer(new int[] { 1, loc - 1 });
						} else { // 갈 조건이 안된다면
							robot.offer(temp);
						}
					}

				}
			} // 2. 로봇움직이기 끝

			// 3. 로봇 올리기
			if (belt[0][0] != 0 && !visited[0][0]) {
				belt[0][0]--;
				visited[0][0] = true;
				moved = true;
				robot.offer(new int[] { 0, 0 });
			}

			// 4. 종료 확인
			if (isZero >= K || !moved) {
				break;
			}
			

		} // end of while

		System.out.println(level);

	}
}

// 1. 회전 2. 1번칸부터 로봇 한칸씩 이동 이동못하면제자리
// 3. 올리는 위치에 로봇 올리기 / 내구도 0이면 안올림

// 결국 로봇이 몇개 올라갔냐 출력하는게 목적

// up 큐 low 큐 두개로 돌린다

//우선 배열로 풀어보자 
//로봇은 큐에 넣자