package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			LinkedList<int[]> list = new LinkedList<int[]>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) { // list에 원본 암호문 넣기
				int[] temp = new int[] { Integer.parseInt(st.nextToken()), j };
				list.offer(temp);
			}

			int M = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), "I");
			for (int j = 0; j < M; j++) {
				String order = st2.nextToken();
				StringTokenizer st3 = new StringTokenizer(order, " ");
				int insert = Integer.parseInt(st3.nextToken());
				int num = Integer.parseInt(st3.nextToken());

				for (int k = insert; k < num + insert; k++) {
					int[] temp = new int[] { Integer.parseInt(st3.nextToken()), k };
					list.add(k, temp);
				}

			}
			for (int j = 0; j < 10; j++) {
				sb.append(list.get(j)[0]).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
