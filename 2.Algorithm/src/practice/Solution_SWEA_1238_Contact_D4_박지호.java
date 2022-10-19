package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_박지호 {
	static class Node {
		int vertex; // 정점 번호
		Node link; // 다음 노드로 연결되는 링크

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	private static Node[] adjList;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			adjList = new Node[101];
			stack = new Stack<Integer>();

			for (int j = 0; j < N / 2; j++) {
				int from = Integer.parseInt(st2.nextToken());
				int to = Integer.parseInt(st2.nextToken());

				adjList[from] = new Node(to, adjList[from]); // 맨앞에 넣으므로 내 주소지를 헤드에, 내가 가리키는 값은 원래 첫째로 저장

			}
//		int cnt = 0;
//		for (Node head : adjList) {
//			if (head != null) {
//				System.out.print(cnt + " : ");
//				System.out.println(head);
//			}
//			cnt++;
//		}

			bfs(adjList, S);
			System.out.println(stack.pop());

		}

	}

	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
//			System.out.println("Node : " + current);

			// current 정점의 인접 정점을 처리(단, 방문하지 않은 인접 정점만)
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			stack.push(current);
		}
	}

}
