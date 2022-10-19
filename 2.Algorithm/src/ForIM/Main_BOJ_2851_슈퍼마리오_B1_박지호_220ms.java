package ForIM;

import java.util.Scanner;

public class Main_BOJ_2851_슈퍼마리오_B1_박지호_220ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}

		int sum = 0;
		int idx = 0;
		for (int i = 0; i < mushroom.length; i++) {
			sum += mushroom[i];
			if (sum >= 100) {
				idx = i;
				break;
			}
		}

		if (idx >= 0) {
			int result = Math.abs(sum - 100) > Math.abs(sum - mushroom[idx] - 100) ? sum - mushroom[idx] : sum;
			System.out.println(result);
		} else {
			System.out.println(mushroom[0]);
		}

	}
}
