package practice;

import java.util.Scanner;

public class Solution_BOJ_17478_재귀함수가뭔가요_박지호_340ms {
	static int num = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		hamsu(num);

	}

	public static void repeat(int k) {
		for (int i = k; i < num; i++) {
			System.out.print("----");
		}
	}

	public static void hamsu(int k) {
		repeat(k);

		System.out.println("\"재귀함수가 뭔가요?\""); // 재귀함수가 뭔가요?
		if (k <= 0) {
			repeat(k);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		} else {
			repeat(k);
			System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."); // 잘들어보게~
			repeat(k);
			System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."); // 잘들어보게~
			repeat(k);
			System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""); // 잘들어보게~
			hamsu(k - 1);
		}
		repeat(k);
		k++;
		System.out.println("라고 답변하였지."); // 라고 답변하였지
	}
}
