import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pos {
	int x;
	int y;
	int cnt;

	public pos(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Main_BOJ_5427_불_G4_박지호_620ms {
	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };
	static int min;
	private static int w, h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < TC; testCase++) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			int[][] visited = new int[h + 2][w + 2];
			// 벽이나 불이면 -1 그외 0

			pos me = null;
			Queue<pos> fires = new LinkedList<pos>();

			for (int i = 1; i < h + 1; i++) {
				String line = br.readLine();
				for (int j = 1; j < w + 1; j++) {
					char temp = line.charAt(j - 1);

					switch (temp) {
					case '@':
						me = new pos(i, j, 0);
						break;

					case '*':
						fires.offer(new pos(i, j, 0));
						visited[i][j] = -1;
						break;

					case '#':
						visited[i][j] = -1;
						break;

					}

				}

			}
			min = Integer.MAX_VALUE;
			bfs(me, fires, visited); // bfs탐색

			if (min != Integer.MAX_VALUE) {
				sb.append(min).append("\n");

			} else {
				sb.append("IMPOSSIBLE").append("\n");

			}

		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);

	}

	public static void bfs(pos me, Queue<pos> fires, int[][] visited) {
		Queue<pos> walk = new LinkedList<pos>();

		visited[me.x][me.y] = -1;
		walk.offer(me);

		while (!walk.isEmpty()) {
			// 불 퍼지는게 먼저
			// 불 큐의 사이즈만큼을 잡아놓는다면 추가로 들어오는 불의 위치 정보는 다음 반복문에서 적용 => 자동으로 1초마다 퍼지는 불을 계산
			for (int i = 0, end = fires.size(); i < end; i++) {
				pos fire = fires.poll();
				int x = fire.x;
				int y = fire.y;

				for (int j = 0; j < 4; j++) {
					int fx = x + dx[j];
					int fy = y + dy[j];

					if (fx > 0 && fy > 0 && fx < h + 1 && fy < w + 1 && visited[fx][fy] != -1) {
						visited[fx][fy] = -1;
						fires.offer(new pos(fx, fy, 0));
					}

				}

			}

			// 상근이 움직임
			for (int i = 0, end = walk.size(); i < end; i++) {
				pos temp = walk.poll();
				int x = temp.x;
				int y = temp.y;
				int cnt = temp.cnt;

				if (x == 0 || y == 0 || x == h + 1 || y == w + 1) {
					min = min > cnt ? cnt : min;
					continue;
				}

				for (int j = 0; j < 4; j++) {
					int fx = x + dx[j];
					int fy = y + dy[j];

					if (fx >= 0 && fy >= 0 && fx <= h + 1 && fy <= w + 1) {
						if (visited[fx][fy] != -1 && visited[fx][fy] != 1) { // 내가 갔던 곳까지 제외
							walk.offer(new pos(fx, fy, cnt + 1));
							visited[fx][fy] = 1;
						}
					}

				}

			}

		}

	}

}
