package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_박지호_117ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			int TC = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] pw = new int[8];

			for (int j = 0; j < pw.length; j++) { // 배열만들기
				int yoso = Integer.parseInt(st.nextToken());
				pw[j] = yoso;
			}

			int cnt = 1;
			while (true) {
				int tmpt = pw[0];
				for (int j = 0; j < pw.length - 1; j++) { // 오른쪽으로 한칸씩 옮김
					pw[j] = pw[j + 1];
				}
				pw[pw.length - 1] = tmpt - cnt;
				cnt++;

				if (pw[pw.length - 1] <= 0) {
					pw[pw.length - 1] = 0;
					cnt = 1;
					break;
				}

				if (cnt > 5) {
					cnt = 1;
				}

			}
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < pw.length - 1; j++) {
				sb.append(pw[j]).append(" ");
			}
			sb.append(pw[pw.length - 1]);
			System.out.println(sb.toString());
		} // end of TC
	}
}

//n개 숫자 입력받아 배열에 저장
//cnt씩 빼준다
//for appand!@#!#@!$
//
//실행 시간 : 0.12797s
//
// 자료구조를 무엇을 사용하는지에 따라 설계 방법이 달라진다
// 한쪽으로 들어가기만 하고 한쪽으로 나가기만 하므로 큐가 적합
// 1~5의 카운트 반복 + 8자리 => 각 수는 15를 감소시킨 후 처음 인덱스로 돌아온다
// 따라서 n*15 값을 빼준 후 연산하면 효율적



