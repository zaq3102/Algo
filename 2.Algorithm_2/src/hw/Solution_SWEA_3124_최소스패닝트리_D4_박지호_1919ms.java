package hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3124_최소스패닝트리_D4_박지호_1919ms {

	static class edge implements Comparable<edge> {
		int from;
		int to;
		int weight;

		public edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			return this.weight - o.weight;
		}

	}

	public static void makeSet() {
		parents = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}

	}

	public static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}

		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int Pa = findSet(a);
		int Pb = findSet(b);

		if (Pa == Pb) {
			return false;
		}

		parents[Pb] = Pa;
		return true;

	}

	static edge[] edgeList;
	static int[] parents;
	private static int V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase < TC + 1; testCase++) {
			st = new StringTokenizer(br.readLine());
			long result = 0;

			V = Integer.parseInt(st.nextToken()); // 노드 수
			int E = Integer.parseInt(st.nextToken()); // 간선 수

			edgeList = new edge[E];
			makeSet();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new edge(from, to, weight);

			}

			Arrays.sort(edgeList);

			for (int i = 0; i < E; i++) {
				edge temp = edgeList[i];

				if (union(temp.from, temp.to)) {
					result += temp.weight;
				}

			}

			sb.append("#").append(testCase).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}

}
