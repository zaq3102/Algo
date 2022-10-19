package Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20413_MVP다이아몬드_박지호_76ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 게임 플레이 개월 수

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		char[] grade = new char[N];
		String line = br.readLine();

		for (int i = 0; i < grade.length; i++) {
			grade[i] = line.charAt(i);
		}

		int prev = 0;
		int sum = 0;

		for (int i = 0; i < grade.length; i++) {
			char temp = grade[i];

			if (temp == 'B') {
				sum += S - 1 - prev;
				prev = S - 1 - prev;

			} else if (temp == 'S') {
				sum += G - 1 - prev;
				prev = G - 1 - prev;
			} else if (temp == 'G') {
				sum += P - 1 - prev;
				prev = P - 1 - prev;
			} else if (temp == 'P') {
				sum += D - 1 - prev;
				prev = D - 1 - prev;
			} else { // D
				sum += D;
				prev = D;
			}

		}

		System.out.println(sum);

	}

}

// 첫 번째 줄에는 게임을 플레이 한 개월수 N
// 두 번째 줄에는 실버, 골드, 플래티넘, 다이아몬드 등급 기준액 s, g, p, d가 만원 단위로 순서대로 주어진다. 브론즈 등급 기준액은
// 0 원
// 세 번째 줄에는 게임을 플레이 한 첫 번째 달부터 N 번째 달까지의 MVP 등급이 등급 표기

// 무조건 시작은 B부터 
// 기준액을 상수로 저장
// 한번 등급을 찍으면 그거 이하로는 안내려간다 => 한번 달성하면 그 금액 대로 MAX값 계속 계산한다는 말

// 첫달 MAX = 29만원
// 두달 SIL => 59만원
// 세달 GOL => 89만원

// 담달 등급이 같냐? 높냐? 로 나눠서 진행
// 1번지부터 시작 
// 뒤부터 D 개수 세서 선 처리 하는것도 방법
