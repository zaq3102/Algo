package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	private static int[][] pan;
	private static int[] result;
	static int cntL, cntR, cntD, fitstI = 0;

	public static void start(int i, int j) {
		System.out.println("start");
		if (cntD >= 99) {
			result[fitstI] = pan[i][j];
			return;
		}
		isLeft(i, j);
		isRight(i, j);

		down(i, j);
	}

	public static void isRight(int i, int j) {
		if (i >= 99) {
			return;
		} else {
			if (pan[i + 1][j] == 1) {
				cntR++;
				isRight(i + 1, j);
			}
		}
	}

	public static void isLeft(int i, int j) {
		if (i <= 0) {
			return;
		} else {
			if (pan[i - 1][j] == 1) {
				cntL++;
				isLeft(i - 1, j);
			}
		}
	}

	public static void move(int i, int j) {
		i += cntR + cntL;
		down(i, j);
	}

	public static void down(int i, int j) {
		cntD++;
		if (cntL == 0 && cntR == 0) {
			start(i, j + 1);
		} else {
			move(i, j);

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		pan = new int[100][100];
		result = new int[100];

		for (int testCase = 1; testCase <= TC; testCase++) {
			sb.append("#").append(testCase).append(" ");

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 100; j++) { // 사다리를 배열에 저장
					pan[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < pan.length; i++) {
				if (pan[i][0] == 1) {
					fitstI = i;
					start(i, 0);
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] == 2) {
				sb.append(i);
				break;
			}
		}
		System.out.println(sb);
	}
}

//사다리 정보를 배열에 저장
//i,j를 담아서 통합메서드에 전달
//통합메서드 = 왼쪽으로얼마만큼가냐 오른쪽으로얼마만큼가냐
//첫 꺾음까지 진행한 다음 이동 => x인덱스값에 +해줌
//해당 인덱스부터 탐색 다시 진행
//if y+1값이 없다면 => 탐색 종료
