package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17135_캐슬디펜스_박지ㅗㅎ {
	public static int[][] field;
	public static int N, M, D;
	public static int[] archer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		D = Integer.parseInt(st.nextToken()); // 궁수 사거리

		field = new int[N + 1][M];
		for (int i = 0; i < N; i++) { // 몬스터 배열 생성
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				field[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		archer = new int[3];
		gameStart(0, 0);

	}

	public static void gameStart(int cnt, int start) { // 게임시작
		if (cnt == 3) {
			hunting(N-1);
			return;
		}

		for (int j = start; j < field.length; j++) { // 궁수위치를 조합의 경우의 수 모두 고려
			archer[cnt] = j;
			gameStart(cnt + 1, j + 1);
		}

	}
	// 궁수의 각각 좌표마다 연산수행 ,
	// 각 궁수의 차례마다 가장 가까운 행을 탐색해서 1을 찾는다
	// 행을 모두 돌아도 3마리의 적을 찾지 못했다면 리턴해준다
	
	public static void hunting(int start) { 
		
		int[][] copy_map = field;
		int cnt = 0;
		
		for (int i = start; i < 0; i--) {
			for (int j = 0; j < M; j++) {
				
			}
		}
		
	}
}

// 몬스터 있는 칸 NxM
// N행 이후로 몬스터가 넘어오면 제외
// 필드에 몬스터가 없으면 게임 종료

// 궁수는 3명 한턴에 한번식 동시공격
// 사거리 D 적이 여럿이면 왼쪽부터 공격
// 한턴 끝나면 몬스터들 내려옴

// 성이올라가는 방식을 채택
// 궁수의 위치를 조합을 통해 구해서 각 경우의 수 중 최대 수를 출력