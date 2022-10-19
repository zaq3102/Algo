package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289_원재의메모리복구 {
	public static void main() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			String val = br.readLine();
			int cnt = 0;
			char pre = '0'; //이전칸의 값
			for (int i = 0; i < val.length(); i++) {
				if(val.charAt(i) != pre) {
					cnt++;
					pre = val.charAt(i);
					//1-0 연산으로 반전 가능
				}
			}
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}

// 문자열을 왼쪽부터 오른쪽으로 순회 for
// 	목표값과 초기값이 다르면 
// 		cnt++,
// 			현재 지점부터 끝까지 for
// 				비트값 반전
// 	목표값과 초기값이 같으면, 다음칸으로 넘어감