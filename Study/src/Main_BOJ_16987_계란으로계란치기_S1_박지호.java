import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16987_계란으로계란치기_S1_박지호 {
	static Point egg[];
	static int N, cnt, max;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		egg = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		dfs(0);
		System.out.println(max);

	}

	static void dfs(int idx) {
		if (idx == N) { // 마지막 계란을 손에 들고있을때
			max = Math.max(cnt, max);
			if (max == N)
				flag = true;
			return;
		}
		if (flag)
			return;
		if (egg[idx].x <= 0) {
			dfs(idx+1);
			return;
		}
		int broken = 0;
		for (int i = 0; i < N; i++) {
			if (i == idx) 
				continue;
			
			if (egg[i].x <= 0) {
				broken++;
				continue;
			}
			egg[idx].x -= egg[i].y;
			egg[i].x -= egg[idx].y;
			if (egg[idx].x <= 0)
				cnt++;

			if (egg[i].x <= 0)
				cnt++;

			dfs(idx + 1);

			if (egg[idx].x <= 0)
				cnt--;

			if (egg[i].x <= 0)
				cnt--;

			egg[idx].x += egg[i].y; // 계란 원상태 복구
			egg[i].x += egg[idx].y;

		}
		if(broken == N-1) {
			dfs(idx+1);
		}

	}

}

// 1번계란으로 2번 3번 4번 ... n번까지 한번씩 친다
// 치다가 손에 든거 깨지거나 다