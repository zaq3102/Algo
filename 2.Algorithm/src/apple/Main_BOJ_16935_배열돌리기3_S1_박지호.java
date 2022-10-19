package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3_S1_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int R = Integer.parseInt(st.nextToken()); // 반복수
		int min = N < M ? N : M;
		int[][] pan = new int[N][M];
		int[] dx = { 0, 1, 0, -1 }; // 우상좌하
		int[] dy = { 1, 0, -1, 0 }; // 우상좌하
		int[] kx = { -1, 1, 0, -1 }; // 좌상우하
		int[] ky = { 0, 0, 1, 0 }; // 좌상우하
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		int S = 0;
		int[][] sol = new int[M][N];
		boolean isReverse = false;

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				pan[i][j] = (Integer.parseInt(st2.nextToken()));
			}
		}

		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
		for (int r = 0; r < R; r++) {
			S = Integer.parseInt(st3.nextToken()); // 연산번호
			if (S == 3 || S == 4)
				
			switch (S) {
			case 1:// 1번 : 배열 상하 반전
				queue.clear();
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						queue.offer(pan[i][j]);
						pan[i][j] = pan[N - 1 - i][j];
						pan[N - 1 - i][j] = queue.poll();
					}
				}

				break;
			case 2:// 2번 : 배열 좌우 반전
				stack.clear();
				for (int i = 0; i < N; i++) {
					for (int j2 = 0; j2 < M; j2++) {
						stack.push(pan[i][j2]);
					}
					for (int j = 0; j < M; j++) {
						pan[i][j] = stack.pop();
					}
				}

				break;
			case 3:// 3번 : 오른쪽으로 90도 회전 => 시계방향으로 n-1칸씩 이동시키면 된다
				stack.clear();
				isReverse = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						stack.push(pan[i][j]);
					}

					for (int j = M - 1; j >= 0; j--) { // 가로세로 길이가 다르면 바꿔줘야하므로
						sol[j][i] = stack.pop();
					}
				}

				break;
			case 4:// 4번 : 왼쪽으로 90도 회전 => 반시계방향으로 n-1칸씩 이동시키면 된다
				stack.clear();
				isReverse = true;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						stack.push(pan[i][j]);
					}

					for (int j = 0; j < M; j++) { // 가로세로 길이가 다르면 바꿔줘야하므로
						sol[j][i] = stack.pop();
					}
				}

				break;
			case 5:// 5번 : 배열을 사사분면으로 분할한 뒤 시계방향으로 블록회전

				break;
			case 6:// 6번 : 5번의 역방향(=반시계방향)

				break;

			}

		}

		if (isReverse) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(sol[i][j]).append(" ");
				}
				sb.append("\n");
			}

		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(pan[i][j]).append(" ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}
// N행 M열 R번 연산 적용
// 1번 : 배열 상하 반전 / 2번 : 배열 좌우 반전
// 3번 : 오른쪽으로 90도 회전
// 4번 : 왼쪽으로 90도 회전
// 5번 : 배열을 사사분면으로 분할한 뒤 시계방향으로 블록회전
// 6번 : 5번의 역방향(=반시계방향)

// 배열에 단순 저장하여 연산 수행 
// 1번안 : 입력배열과 출력배열을 따로 분리해서 연산수행 후 옮겨주는 작업을 수행 => 단순하지만 시간, 메모리 고려
// 2번안 : 원래 배열에 변화를 직접 적용시킨다 

// 큐 사용 좌 <-우 방향
// 1번 : 0번지를 n개 poll 해서 마지막번째 큐에 offer 1번지를 n개 poll해서 마지막-1번째 큐에 offer... 
// 2번 : 스택 하나를 두고 스택에 모두 저장했다가 그대로 pop한 값을 배열에 저장 
// 3번 : 제일 아래 큐부터 n개 poll 해서 제일 위 큐부터 아래까지 하나씩 poll
// 4번 : 0번지부터 n개씩 빼서 제일 마지막 큐부터 한개씩 offer
// 5번 : 제일 아래큐부터 n개 poll해서 1, 3번째 큐에 offer 그다음 큐는 0,2번째 큐에 offer ...
// 6번 : 제일 위 큐부터 n개 poll 해서 3, 1번째 큐에 offer 그다음 큐는 2,0번째 큐에 offer

// 1번의 경우 2차원배열의 1차원배열을 바꿔주면 쉽게 풀 수 있다
// 3 4번의 경우 pan을 재정의해서 M과 N을 바꿔주면서 푼다
