import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/
// 무향 그래프
public class AdjMatrixTest {
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();

		int[][] adjMatrix = new int[N][N];

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[from][to] = adjMatrix[to][from] = 1; // 무향이니까 반대로 뒤집어서도 넣어줘야함

		}

//		for (int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
//		bfs(adjMatrix, 0);
		dfs(adjMatrix, new boolean[N], 0);

	}

	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char) (current + 65));

			// current 정점의 인접 정점을 처리(단, 방문하지 않은 인접 정점만)
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[current][i] != 0) {
					queue.offer(i);
					visited[i] = true;
				}
			}

		}

	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {

		visited[current] = true;
		System.out.println(current);

		// current 정점의 인접 정점을 처리(단, 방문하지 않은 인접 정점만)
		for (int i = 0; i < N; i++) {
			if (!visited[i] 
					&& adjMatrix[current][i] != 0) {
				dfs(adjMatrix, visited, i);
			}
		}

	}
}
