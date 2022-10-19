package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2477_참외밭_S4_박지호_124ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] line = new int[6][2];
		int width_index = 0;
		int height_index = 0;
		int width_max = 0;
		int height_max = 0;

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken()); // 방향
			line[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < 6; i++) {
			if (line[i][0] == 1 || line[i][0] == 2) { // 가로방향이라면
				if (width_max < line[i][1]) {
					width_max = line[i][1];
					width_index = i;
				}

			} else if(line[i][0] == 3 || line[i][0] == 4) { // 세로방향이라면
				if (height_max < line[i][1]) {
					height_max = line[i][1];
					height_index = i;
				}
			}
		}

		int width = 0;
		int height = 0;
		if (width_index == 0) {
			width = Math.abs(line[5][1] - line[width_index + 1][1]);
		} else if (width_index == 5) {
			width = Math.abs(line[width_index - 1][1] - line[0][1]);
		} else {
			width = Math.abs(line[width_index - 1][1] - line[width_index + 1][1]);
		}

		if (height_index == 0) {
			height = Math.abs(line[5][1] - line[height_index + 1][1]);
		} else if (height_index == 5) {
			height = Math.abs(line[height_index - 1][1] - line[0][1]);
		} else {
			height = Math.abs(line[height_index - 1][1] - line[height_index + 1][1]);
		}

		int sub_square = width * height;

		System.out.println((width_max * height_max - sub_square) * K);
	}
}

// 동 1 서 2 남 3 북 4