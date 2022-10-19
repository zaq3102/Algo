import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_3190_뱀_G5_박지호 {

	private static int N, L, K;
	private static List<int[]> snake;
	private static int[][] map;
	private static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	private static int[] dy = { 1, 0, -1, 0 }; // 우 하 좌 상

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		snake = new LinkedList<int[]>();
		snake.add(new int[] { 1, 1 });

		N = Integer.parseInt(br.readLine()); // 보드 크기
		map = new int[N + 1][N + 1];

		K = Integer.parseInt(br.readLine()); // 사과 개수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;

		}

		L = Integer.parseInt(br.readLine());
		int[][] dir = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i][0] = Integer.parseInt(st.nextToken());
			String temp = st.nextToken();

			if (temp.equals("L")) {
				dir[i][1] = -1; // 왼쪽으로 90도 회전
			} else {
				dir[i][1] = 1; // 오른쪽으로 90도 회전
			}

		}

		int time = solution(1, 1, 0, dir);
		System.out.println(time);

	}

	public static int solution(int x, int y, int d, int[][] dir) {
		int time = 0;
		int turn = 0;

		while (true) {
			time++;
			int fx = x + dx[d];
			int fy = y + dy[d];

			if (isFinished(fx, fy))
				break;

			if (map[fx][fy] == 2) {
				snake.add(new int[] { fx, fy });
			} else {
				snake.add(new int[] { fx, fy });
				snake.remove(0); // 가장 뒷부분 = 꼬리 제거
			}

			x = fx;
			y = fy;

			if (turn < L) {
				if (time == dir[turn][0]) { // 방향전환할 타이밍인지 확인
					d = nextD(d, dir[turn][1]);
					turn++;
				}

			}

		}
		return time;
	}

	private static int nextD(int d, int i) {
		int next = (d + i) % 4;
		if (next == -1) // d = 0, i = -1 인 경우 (d = 3, i = 1 의 경우 위의 %를 통해 해결된다)
			next = 3;

		return next;
	}

	private static boolean isFinished(int fx, int fy) {
		if (fx < 1 || fy < 1 || fx > N || fy > N) {
			return true;
		}

		for (int i = 0; i < snake.size(); i++) {
			int body_x = snake.get(i)[0];
			int body_y = snake.get(i)[1];

			if (body_x == fx && body_y == fy) {
				return true;
			}

		}
		return false;

	}

}

// 리스트에 뱀 몸통의 좌표를 넣어서 가져간다
// 
