import java.util.Arrays;
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
public class AdjListTest {
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

	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();

		Node[] adjList = new Node[N];

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt(); // from의 인접리스트에 to 정점 추가 (맨앞에)
			// 무향이므로 간선 하나로 양방향 처리
			adjList[from] = new Node(to, adjList[from]); // 맨앞에 넣으므로 내 주소지를 헤드에, 내가 가리키는 값은 원래 첫째로 저장
			adjList[to] = new Node(from, adjList[to]); // 양방향이라 뒤집어서 넣어줌
		}

		for (Node head : adjList) {

			System.out.println(head);
		}
		System.out.println("=========================");
//		bfs(adjList, 0);
		
		for (int i = 0; i < adjList.length; i++) {
			dfs(adjList, new boolean[N], i);
		}

	}

	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start); // queue에 노드 번호만 넣어준다
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char) (current + 65));

			// current 정점의 인접 정점을 처리(단, 방문하지 않은 인접 정점만)
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}

	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true; // 방문체크
		System.out.println(current);

		// current 정점의 인접 정점을 처리(단, 방문하지 않은 인접 정점만)
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(adjList, visited, temp.vertex);
			}
		}

	}

}

// 인접한 노드로 1씩 순차진행 => BFS
