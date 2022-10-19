package apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_박지호 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] m = new int[N][N];
			int r = 0; // 행
			int c = 0; // 열
			
			int size = N-1;  // 이동할 크기
			int num = 1; // 저장할 숫자
			
			while(size > 0) {
				for (int i = 0; i < size; i++) { // 우
					m[r][c++] = num++;	
					
				}
				for (int i = 0; i < size; i++) { // 하
					m[r++][c] = num++;	
					
				}
				for (int i = 0; i < size; i++) { // 좌
					m[r][c--] = num++;	
					
				}
				for (int i = 0; i < size; i++) { // 상
					m[r--][c] = num++;	
					
				}
				r++;
				c++; // 좌표 시작 위치 수정
				size -= 2;
				
			} // end of while
			
			
			if(N % 2 != 0) { // 홀수라면
				m[r][c] = num;
				
			}
			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.append("\n");
			}

			
		} // end of for
	
		System.out.print(sb.toString());
		
	}
}


// N
// while(size>0)
//	 size = N-1 우, 하, 좌, 상
//	 size = N-3
//	 size = N-5
// N == 홀수 가운데 값을 N*N 저장

