import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11559_PuyoPuyo_G4_박지호2 {
	static char[][] pan;
	static int[][] visited;
	static int[] dx = {-1,1,0,0}; // 상 하 좌 우  int[x][y] 꼴로 사용
	static int[] dy = {0,0,-1,1};
	
	static class yo {
		int x;
		int y;
		char color;
		
		public yo(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}

		@Override
		public String toString() {
			return "yo [x=" + x + ", y=" + y + ", color=" + color + "]";
		}
		
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		Queue<yo> RedQ = new LinkedList<yo>();
		Queue<yo> GreenQ = new LinkedList<yo>();
		Queue<yo> BlueQ = new LinkedList<yo>();
		Queue<yo> PurpleQ = new LinkedList<yo>();
		Queue<yo> YellowQ = new LinkedList<yo>();

		
		pan = new char[12][6];
		char temp;

		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				temp = st.nextToken().charAt(0);
				pan[i][j] = temp;

				if (temp == 'R') {
					RedQ.offer(new yo(i,j,temp));
					visited[i][j] = 1;
				} else if (temp == 'G') {
					GreenQ.offer(new yo(i,j,temp));
					visited[i][j] = 2;
				} else if (temp == 'B') {
					BlueQ.offer(new yo(i,j,temp));
					visited[i][j] = 3;
				} else if (temp == 'P') {
					PurpleQ.offer(new yo(i,j,temp));
					visited[i][j] = 4;
				} else if (temp == 'Y') {
					YellowQ.offer(new yo(i,j,temp));
					visited[i][j] = 5;
				}

			}
		} // end of for
		
		while(true) {
			
			if(!RedQ.isEmpty()) {
				bfs(RedQ);
				
				
			}
			
			
			
			
		}
		

	} // end of main
	
	public static void bfs(Queue<yo> ColorQ) {
		boolean[][] check = new boolean[12][6];
		Queue<yo> tempQ = new LinkedList<yo>();
		yo temp = ColorQ.poll();
		
		
		
		
		
		
		
		
	} // end of bfs
	

} // end of class


// RGBPY 12345
// 색깔별로 큐를 만들자
// 같은색인지 확인하는 방법 => 큐 이용 BFS
// 방문배열 만들어서 체크해주면서 카운트 체크 => 카운트4이상 && 큐사이즈0 라면 
// 이때 색깔별로 한번씩 bfs를 돌려줘야된다

// 1. 각 색마다 초기 정보를 색별 큐에 저장
// 2. 색별로 bfs 돌림 => 
// 3. 전체 색 한번씩 bfs 돌린 뒤 visited 벼열에 0인 값 구분해서 지워진 뿌요만큼 아래로 이동
// 4. erased 전역 변수를 써서 erased = 0 이면 반복문 종료 == 더 이상 지워질 뿌요가 없다



