package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JOL_1681_해밀턴순환회로_박지호_151ms {
	private static int N;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		adjMatrix = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		visited[0] = true;
		dfs(1, 0, 0); // 시작지점이 1이므로 방문했다는 조건 하에 시작 => cnt = 1
		System.out.println(answer);
	}

	public static void dfs(int cnt, int current, int sum) {

		if (sum > answer) // 가지치기
			return;

		if (cnt == N) {
			if (adjMatrix[current][0] != 0 && answer > sum + adjMatrix[current][0]) {
				answer = sum + adjMatrix[current][0];
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i] == false && adjMatrix[current][i] != 0) {
				visited[i] = true;
				dfs(cnt + 1, i, sum + adjMatrix[current][i]);
				visited[i] = false; // 다음 순환을 위해 미방문처리
			}
		}

	}
}
