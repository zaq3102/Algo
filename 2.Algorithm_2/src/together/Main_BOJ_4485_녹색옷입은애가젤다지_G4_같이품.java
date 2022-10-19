package together;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * DFS로 하면 시간초과
 * 
 * 다익스트라 : 한 정점에서 -> 나머지 정점까지 최단거리 (음이 아닌 가중치) n^2 벨만포드 : 한 정점에서 -> 나머지 정점까지
 * 최단거리 (음의 가중치 포함) 플로이드 워샬 : 모든 정점 -> 모든 정점 최단거리 n^3
 * 
 * 
 * 
 */

public class Main_BOJ_4485_녹색옷입은애가젤다지_G4_같이품 {

	private static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1;; testCase++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int[][] m = new int[N][N];
			int[][] visited = new int[N][N]; // 가중치 담은 배열
			for (int i = 0; i < m.length; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < m.length; j++, index += 2) {
					m[i][j] = str.charAt(index) - '0';
					visited[i][j] = Integer.MAX_VALUE;
				}
			}

			PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			}); // {r,c, 현재까지의거리}
			visited[0][0] = m[0][0];
			q.add(new int[] { 0, 0, visited[0][0] });
			while (q.size() > 0) {
				int[] data = q.poll();
				int r = data[0];
				int c = data[1];
				int cost = data[2]; // 큐에 삽입할 당시의 시작점부터 현재까지 거리
				if (visited[r][c] < cost) { // 가지치기 : 이미 더 작은 값으로 업데이트 된 경우
					continue;
				}

				for (int i = 0; i < dx.length; i++) {
					int nr = r + dx[i];
					int nc = c + dy[i];
					if (0 <= nr && nr < N && 0 <= nc && nc < N && visited[nr][nc] > cost + m[nr][nc]) {
						visited[nr][nc] = cost + m[nr][nc];
						q.add(new int[] { nr, nc, cost + m[nr][nc] });
					}

				}

			}

			sb.append("Problem ").append(testCase).append(": ").append(visited[N - 1][N - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
