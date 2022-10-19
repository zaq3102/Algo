package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrawberryCake {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {

			int N = Integer.parseInt(br.readLine());

			int[][] pan = new int[N][N];

			int Total_Berry = 0;

			for (int i = 0; i < pan.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < pan.length; j++) {
					int temp = Integer.parseInt(st.nextToken());
					Total_Berry += temp;
					pan[i][j] = temp;
				}
			}

			int garo = 0;
			boolean isGaro = false;
			for (int i = 0; i < pan.length; i++) {
				for (int j = 0; j < pan.length; j++) {
					garo += pan[i][j];
				}
				if (garo == Total_Berry / 2) {
					isGaro = true;
					break;
				}
			}

			int sero = 0;
			boolean isSero = false;
			if (isGaro) {
				for (int i = 0; i < pan.length; i++) {
					for (int j = 0; j < pan.length; j++) {
						sero += pan[j][i];
					}
					if (sero == Total_Berry / 2) {
						isSero = true;
						break;
					}
				}
			}

			sb.append("#").append(testCase).append(" ");
			if (isGaro && isSero) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}

// 배열에 넣을때 딸기 총 개수를 카운팅
// 이후 가로로 쭉쭉 탐색하면서 딸기개수를 카운팅 N / 2 개의 딸기가 생기는 행을 찾는다
// 다시 세로로 쭉쭉 탐색하면서 딸기개수를 카운팅 N / 2 개의 딸기가 생기는 행을 찾는다
// 나눠지면 1 아니면 0