package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 반복문으로 분할정복
 */
public class Main_BOJ_1074_Z_박지호_같이품2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 2차원배열 크기 2^N * 2^N / 1<= N <= 15
		int r = Integer.parseInt(st.nextToken()); // 행 0 <= r,c <= 2^N
		int c = Integer.parseInt(st.nextToken()); // 열

		int rs = 0; // 사각형의 시작좌표
		int cs = 0;
		int answer = 0;

		while (N > 0) {
			int size = 1 << (N - 1); // 정사각형 한 변의 길이
			int diff = size * size; // 정사각형 면적 (내부개수)
			if (r < rs + size && c < cs + size) { // 좌상

			} else if (r < rs + size && cs + size <= c) { // 우상
				answer += diff;
				cs += size;
			} else if (rs + size <= r && c < cs + size) { // 좌하
				answer += diff * 2;
				rs += size;
			} else { // 우하
				answer += diff * 3;
				cs += size;
				rs += size;
			}
			N--;
		}
		System.out.println(answer);

	}

}
