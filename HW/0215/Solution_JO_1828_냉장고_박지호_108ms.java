package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_JO_1828_냉장고_박지호_108ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2]; // 0행 : 최저 / 1행 : 최고

		int count = 1; // 냉장고 수 => 최저에서 기본 1개는 필요하므로 초기값 1

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 최저온도
			arr[i][1] = Integer.parseInt(st.nextToken()); // 최고온도
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return Integer.compare(o1[1], o2[1]);
			}

		});

		int max_Degree = arr[0][1]; // 첫번째값을 최고온도로 설정

		for (int i = 0; i < N; i++) {
			if (arr[i][0] <= max_Degree) { // i번째 값의 최저,최고온도보다 max가 크면
				if (arr[i][1] < max_Degree) {
					max_Degree = arr[i][1]; // max값은 i,1
				}
				continue;
			}

			else {
				max_Degree = arr[i][1];
				count++;
			}

		}
		System.out.println(count);

	}

}
