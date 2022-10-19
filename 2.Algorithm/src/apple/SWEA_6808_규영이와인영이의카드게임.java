package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
	static boolean[] isSelected;
	static int[] gyu;
	static int[] in;
	static int[] result;

	static int pointG;
	static int pointI;
	static int resultG;
	static int resultI;

	public static void Permutation(int cnt) {
		if (cnt == 9) {
			pointG = 0;
			pointI = 0;
			for (int i = 0; i < gyu.length; i++) {
				if (gyu[i] > result[i]) { // 규영승리
					pointG += gyu[i] + result[i];
				} else { // 인영승리
					pointI += gyu[i] + result[i];
				}
			}

			if (pointG > pointI) {
				resultG++;
			} else if (pointG < pointI) {
				resultI++;
			}
//			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i]) {
				continue;
			}
			result[cnt] = in[i];
			isSelected[i] = true;
			Permutation(cnt + 1);
			isSelected[i] = false;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= TC; testCase++) {
			gyu = new int[9];
			in = new int[9];
			boolean[] check = new boolean[18];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 9; i++) { // 규영이 카드 배열
				int temp = Integer.parseInt(st.nextToken());
				gyu[i] = temp;
				check[temp - 1] = true;
			}

			int idx = 0;
			for (int i = 0; i < check.length; i++) { // 인영이 카드 배열
				if (check[i] == false) {
					in[idx++] = i + 1;
				}
			}

			result = new int[9];
			isSelected = new boolean[9];

			resultG = 0;
			resultI = 0;

			Permutation(0);

			sb.append("#").append(testCase).append(" ").append(resultG).append(" ").append((362880 - resultG))
					.append("\n");
//			System.out.println(resultG + ", " + (362880 - resultG));
		}
		System.out.println(sb);
	}
}

// 규영이가 카드 내는 순서는 입력으로 받는다
// 인영이가 카드를 내는 경우의 수를 구해자 => nPr n=r=9 => 9!가지 
