package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2493_탑_G5_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N];
		int[] receive = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;

		for (int i = 0; i < N; i++) { // 탑 배열 입력
			top[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i > 0; i--) { // 기준 탑
			for (int j = i - 1; j >= 0; j--) { // 한칸씩 앞으로 이동시킬 탑
				if (top[i] > top[j]) {
					cnt++;
				} else {
					if (cnt != 0) {
						for (int k = 0; k < cnt; k++) {
							receive[i - k] = j + 1;
						}
						cnt = 0;
					} else {
						receive[i] = j + 1;
					}
					break;
				}
			}
			cnt = 0;
		}

		for (int i = 0; i < receive.length - 1; i++) {
			sb.append(receive[i]).append(" ");
		}
		sb.append(receive[receive.length-1]);
		System.out.println(sb.toString());
	}
}

//top[N-1] 랑 그 앞꺼랑 비교 
//만약 앞에가 같거나 크다 해당 인덱스를 receive에 저장
//만약 앞에가 작다 continue로 넘김