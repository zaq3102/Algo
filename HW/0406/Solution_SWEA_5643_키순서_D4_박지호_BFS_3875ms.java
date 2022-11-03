package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_D4_박지호_BFS_3875ms {

	static int[][] adjMatrix;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			N = Integer.parseInt(br.readLine()); // 학생 수
			M = Integer.parseInt(br.readLine()); // 비교 횟수

			// 인접행렬 : 0으로 자동 초기화 (0 : 키관계 모름, 1 : 자신보다 키가 큰 학생과의 관계 표현)
			adjMatrix = new int[N + 1][N + 1]; // 학생번호 1부터 시작하도록

			StringTokenizer st = null;
			int a, b;
			for (int i = 1; i <= M; i++) { // 간선 정보 입력받아 인접행렬에 표현
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;

			}

			int answer = 0; // 자신의 키를 알 수 있는 학생 수
			for (int i = 1; i <= N; i++) {
				if (gtBFS(i, new boolean[N + 1]) + ltBFS(i, new boolean[N + 1]) == N - 1) {
					++answer;
				}

			}

			System.out.println("#" + testCase + " " + answer);

		}
	}

	static int gtBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {

			int cur = queue.poll();
			for (int i = 1; i <= N; i++) { // 모든 학생을 들여다 보며 자신보다 키가 큰 학생 따라 탐색
				if (adjMatrix[cur][i] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					queue.offer(i);
				}

			}

		}
		return cnt;

	}

	static int ltBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {

			int cur = queue.poll();
			for (int i = 1; i <= N; i++) { // 모든 학생을 들여다 보며 자신보다 키가 큰 학생 따라 탐색
				if (adjMatrix[i][cur] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					queue.offer(i);
				}

			}

		}
		return cnt;

	}

}

// 자신의 키 순서를 안다 = 내앞에 몇명인지, 내뒤에 몇명인지 안다

// 1. 나한테 들어오는 간선 수 + 들어오는 노드에 연결된 하위 간선 수
// 2. 내가 상위로 보내는 간선 수
// => 결국 모든 노드에 도달 가능해야한다 = 플로이드-워샬 기법