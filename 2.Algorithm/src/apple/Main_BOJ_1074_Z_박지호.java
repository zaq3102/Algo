package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 2차원배열 크기 2^N * 2^N
		int r = Integer.parseInt(st.nextToken()); // 행
		int c = Integer.parseInt(st.nextToken()); // 열
			
		
		
		
	}
	
	public static void Z(int ga,int se) {
		
		
		Z(ga/2, se/2);
		
		
		
	}
	
}

//분할정복
//x랑 y 좌표에서 r,c를 찾을때까지 반으로 나누고 나누고 해야한다