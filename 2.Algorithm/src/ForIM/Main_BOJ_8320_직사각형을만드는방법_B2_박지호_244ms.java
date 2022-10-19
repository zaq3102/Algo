package ForIM;

import java.util.Scanner;

public class Main_BOJ_8320_직사각형을만드는방법_B2_박지호_244ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 1; i <= N / 2; i++) { // 세로

			for (int j = i; j <= N; j++) { // 가로
				if (i * j <= N) {
					cnt++;
				}

			}

		}
		
		if(N == 1) {
			cnt++;
		}
		System.out.println(cnt);
	}

}

// 1개 써서 2개써서 ... N개 써서