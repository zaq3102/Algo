package Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스_S3_박지호 {
	static Queue<int[]> queue;
	private static int[][] pan;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		pan = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			pan[from][to] = 1;
			pan[to][from] = 1;

		}
		queue = new LinkedList<int[]>();
		queue.offer(new int[] { 1, 1 });
		bfs();

	}

	public static void bfs() {

		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			int x = temp[0];
			int y = temp[1];
			
			
			
			
		}
		
		
		
	}
}
