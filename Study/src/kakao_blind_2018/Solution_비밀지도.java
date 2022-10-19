package kakao_blind_2018;

import java.util.Arrays;

public class Solution_비밀지도 {
	public static void main(String[] args) {

		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };

		String[] result = solution(n, arr1, arr2);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {

		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], ' ');
		}

		for (int i = 0; i < n; i++) {
			String bin1 = Integer.toBinaryString(arr1[i]);
			String bin2 = Integer.toBinaryString(arr2[i]);

			for (int j = bin1.length() - 1; j >= 0; j--) {
				if (bin1.charAt(j) == '1') {
					map[i][(n - 1) - ((bin1.length() - 1) - j)] = '#';
				}
			}

			for (int j = bin2.length() - 1; j >= 0; j--) {
				if (bin2.charAt(j) == '1') {
					map[i][(n - 1) - ((bin2.length() - 1) - j)] = '#';
				}
			}
		}

		String[] answer = new String[n];
		Arrays.fill(answer, "");

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				answer[i] += map[i][j];
			}
		}

		return answer;
	}
}
