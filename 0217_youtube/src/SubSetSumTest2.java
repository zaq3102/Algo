
import java.util.Scanner;

public class SubSetSumTest2 {
	static int N, input[], S, ans;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 집합 크기
		S = sc.nextInt(); // 목표합
		ans = 0;
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0, 0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt, int sum) { // cnt : 부분집합에 고려해야 하는 원소 = 직전까지 고려한 원소 수
															// sum : 직전까지 구성된 부분집합의 합

		if (sum == S) {
			++ans;
			for (int i = 0; i < cnt; i++) {
				System.out.print(isSelected[i] ? input[i] + " " : "");
			}
			System.out.println();
			return;
		}
		if (sum > S) {
			return; // 이미 넘은 경우 뒤의 경우의 수를 고려할 필요가 없다 => 그냥 리턴해줌
		}

		if (cnt == N) { // 마지막 원소까지 부분집합에 다 고려된 상황, 근데 목표합보다 작다 => 그냥 리턴

			return;
		}

		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum + input[cnt]);
//		System.out.println("1현재 cnt : " + cnt);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum); // 선택안했으니까 sum에 변화는 없다
//		System.out.println("2현재 cnt : " + cnt);
	}
}
