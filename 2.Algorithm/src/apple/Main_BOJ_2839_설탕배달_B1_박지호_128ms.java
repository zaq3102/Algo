package apple;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_B1_박지호_128ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int result = 0;

		while (true) {
			if (N % 5 == 0) { // 딱떨어지면
				result += N / 5;
				System.out.println(result);
				break;
			} else { // 딱 안떨어지면 3키로 포대를 하나씩 추가한다는 생각으로 접근
				N -= 3;
				result++;
			}

			if (N < 0) { // 음수가 나오면 딱떨어지지 않는 수이다
				System.out.println("-1");
				break;
			}

		}

	}
}
// 위 방식을 Greedy 방법이라고 볼 수 있다

// 배달하는 설탕 무게 N kg
// 설탕봉지는 3, 5kg  최대한 적은 봉지를 들고가는 것이 목표
// 배달하는 최소 봉지 수 출력 / 정확하게 N kg 만들수없다면 -1 출력

// 3의 배수이거나 5의 배수 => 배달가능
// 사실상 N 을 만들 수 없는 상황 => 4, 7

// 끝자리만 생각해보자 => 10n +1? 꼴로 하면 10n은 5kg짜리로 처리하고 1?만 고려하면 됨
// 1 5 1개 3 2개로 11을 만들어놓고 나머지는 5로 퉁칠수있음
// 2 3 4개로 12를 말들어놓고 나머지 5로
// 3 5 2개 3 1개
// 4 5 1개 3 3개
// 5 5 3개
// 6 5 2개 3 2개
// 7 5 1개 3 4개
// 8 5 3개 3 1개
// 9 5 2개 3 3개
// 0 5 2개
// 1002와 같은 숫자는 계산할 수 없다 => 오류
