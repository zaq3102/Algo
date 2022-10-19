import java.util.Scanner;

public class NQueenBackTrackingTest2 {
	static int N, answer;
	static int col[]; // 열번호

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = 0;
		col = new int[N + 1]; // 0인덱스는 안쓸거임
		setQueen(1);
		System.out.println(answer);
	}

	public static void setQueen(int rowNo) { // rowNo : 퀸을 두어야하는 현재 행

		if (rowNo > N) { // 기저조건 : 퀸을 모두 놓았다면
			answer++;
			return;
		}

		// 1열부터 n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) { // 매번 놓는 층들의 위치를 기억해야한다
			col[rowNo] = i;
			if (isAvailable(rowNo)) { // 유망한 상황인지 판단한 다음
				setQueen(rowNo + 1); // 다음으로 넘어간다
			}
		}

	}

	public static boolean isAvailable(int rowNo) { // rowNo : 놓아진 마지막 퀸

		for (int i = 1; i < rowNo; i++) {
			if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i])) { // 기존 퀸과 비교 퀸이 같은 열이라면 || 가로 세로
																						// 움직임의 변화량이 같다면 => 대각선이라면
				return false;
			}
		}
		return true;

	}

}
