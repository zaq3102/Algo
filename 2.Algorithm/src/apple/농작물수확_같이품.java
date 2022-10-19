package apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확_같이품 {
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					if( N/2 <= i + j && i + j <= N/2*3
						&& -N/2 <= i - j && i - j <= N / 2	) { // 마름모 영역에 들어갔다면
						sum += s.charAt(j) - '0';
					}
				}
				
				

			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}

		System.out.println(sb.toString());

	}
}

//StringBuilder sb = new StringBuilder();
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int TC = Integer.parseInt(br.readLine());
//for (int testCase = 1; testCase <= TC; testCase++) {
//	int N = Integer.parseInt(br.readLine());
//	int sum = 0;
//
//	for (int i = 0; i < N; i++) {
//		String s = br.readLine();
//		int x = Math.abs(N / 2 - i); // i행에서 합산을 시작할 열의 좌표
//		for (int j = x; j < N - x; j++) { // i행의 마름모 영역 구분
//			sum += s.charAt(j) - '0';
//		}
//
//	}
//	sb.append("#").append(testCase).append(" ").append(sum).append("\n");
//}
//
//System.out.println(sb.toString());
