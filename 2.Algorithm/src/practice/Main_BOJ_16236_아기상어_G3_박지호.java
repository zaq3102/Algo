package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_G3_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<fish> fish = new LinkedList<fish>();
		
		int N = Integer.parseInt(br.readLine());
		int[][] pan = new int[N][N];
		
		for (int i = 0; i < pan.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < pan.length; j++) {
				if(Integer.parseInt(st.nextToken()) != 0 && Integer.parseInt(st.nextToken()) != 9) {
					
				}
				
			}
		}
		
	}

	public class fish {
		int x;
		int y;
		int size;

		public fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}

	}
}
