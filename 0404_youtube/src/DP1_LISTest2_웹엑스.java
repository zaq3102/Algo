import java.util.Arrays;
import java.util.Scanner;

public class DP1_LISTest2_웹엑스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열 길이
		int[] arr = new int[N]; // 수열의 원소들 저장
		int[] LIS = new int[N]; // 자신을 끝으로 하는 LIS길이
		int[] path = new int[N]; // 나의 앞에 위치한 수열의 idx
		Arrays.fill(path, -1);

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 0; // 해당 수열의 LIS 최장길이
		int maxIndex = -1;
		for (int i = 0; i < N; i++) { // 모든 원소에 대해 ㅐ자신을 그틍로 하는 LIS 길이 생산
			LIS[i] = 1; // 자신 혼자 LIS 구성할 때의 길이 1로 초기화
			for (int j = 0; j < i; j++) { // 첫 원소부터 i원소 직전까지 비교
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					path[i] = j;
				}
			}
			if (max < LIS[i]) {
				max = LIS[i];
				maxIndex = i;
			}
		}
		System.out.println("LIS의 최대값 : " + max);
		System.out.println("LIS의 최대값 index : " + maxIndex);
		System.out.println("LIS의 마지막 숫자 : " + arr[maxIndex]);
		System.out.println("LIS의 마지막 숫자의 부모 : " + path[maxIndex]);
		System.out.println("====================");

		String result = "";
		do {
			result = path[maxIndex] + " " + result;
			maxIndex = path[maxIndex];
		} while (maxIndex != -1);
		System.out.println(result);
	}
}
