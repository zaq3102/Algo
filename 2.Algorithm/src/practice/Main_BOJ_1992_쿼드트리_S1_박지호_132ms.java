package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_S1_박지호_132ms {
	static StringBuilder sb = new StringBuilder();
	 static int[][] pan;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pan = new int[N][N];
		
		for (int i = 0; i < N; i++) { // 영상배열저장
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				pan[i][j] = line.charAt(j)-'0';
			}
		}
		
		divide(N,0,0);
		System.out.println(sb);
		

	}
	
	public static void divide(int n, int sr, int sc) {
		if (isPossible(n,sr,sc)) {
			sb.append(pan[sr][sc]);
			return;
		}
		
		sb.append('(');
		
		// 큰 네모 하나를 4개로 분할하는 파트
		divide(n/2, sr, sc); // 좌상
		divide(n/2, sr, sc + n/2); // 우상
		divide(n/2, sr + n/2, sc); // 좌하
		divide(n/2, sr + n/2, sc + n/2); // 우하
		
		sb.append(')');
	}
	
	public static boolean isPossible(int n, int sr, int sc) {
		int value = pan[sr][sc];
		
		for (int i = sr; i < sr + n; i++) {
			for (int j = sc; j < sc + n; j++) {
				if(value != pan[i][j]) { // 큰 네모 하나가 통일된 값이냐 아니냐를 판별
					return false; 
					
				}
			}
		}
		
		
		
		
		return true;
	}

}

// 분할정복으로 푼다
// 핵심은 커다란 네모 하나로 생각해서 배열을 돌리다 값이 다르면
// => 4개로 분할정복시켜서 다시 각각의 네모를 하나의 네모로 생각하고 배열을 돌리고 ... 를 반복!