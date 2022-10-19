package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걸어가기_S1_박지호_252ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] { x, y });
			}

			boolean[][] flag = new boolean[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					int[] pos = list.get(i), next = list.get(j);
					int dis = Math.abs(pos[0] - next[0]) + Math.abs(pos[1] - next[1]);

					if (dis <= 1000)
						flag[i][j] = true;
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						if (flag[i][k] && flag[k][j]) {
							flag[i][j] = true;
						}
					}
				}
			}
			if (flag[0][n + 1]) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}

		} // end of main
		System.out.println(sb);
	}
}

// 맥주는 20병 개당 50미터 => 1000미터까지는 편의점없이 가능
// 1. 집에서 바로 가능한가 -> 편의점 1을 거쳐서 가능한가 -> 편의점 2를 거쳐서....
// 2. BFS로 전체 탐색하면서 움직일때마다 변수감소 / 편의점 닿을때마다 DRINK 변수를 1000으로 초기화
// 3. 플로이드-와샬 / A~B 까지의 x좌표+y좌표 = 간선의 가중치