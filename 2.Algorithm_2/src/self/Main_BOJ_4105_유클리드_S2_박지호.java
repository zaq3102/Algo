package self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4105_유클리드_S2_박지호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		double[][] pos = new double[6][2];

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 6; i++) {
				pos[i][0] = Double.parseDouble(st.nextToken());
				pos[i][1] = Double.parseDouble(st.nextToken());
			}

			// 신발끈 공식으로 삼각형 넓이 구하기
			double shoe = (pos[3][0] * pos[4][1] + pos[4][0] * pos[5][1] + pos[5][0] * pos[3][1])
					- (pos[4][0] * pos[3][1] + pos[5][0] * pos[4][1] + pos[3][0] * pos[5][1]);

			double triangle = 0.5 * Math.abs(shoe);

			double dx = Math.pow(pos[1][0] - pos[0][0], 2);
			double dy = Math.pow(pos[1][1] - pos[0][1], 2);
			double line = Math.sqrt(dx + dy);

			double h = triangle / line; // AB와 H사이의 거리
			
		}

	}
}
