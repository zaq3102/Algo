package ForIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미_S4_박지호_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());

//		int moveX = 1;
//		int moveY = 1;
//
//		for (int i = 0; i < t; i++) {
//
//			if (p == 0 || p == w) {
//				moveX *= -1;
//			}
//			if (q == 0 || q == h) {
//				moveY *= -1;
//			}
//
//			p += moveX;
//			q += moveY;
//
//		} // 계산하면 무조건 틀린다 => 애초에 수학적 수식으로 끝내야함

		if(((int)(p + t) / w) % 2 == 0) {
			p = (p + t) % w;
		}else {
			p = w - (p + t) % w; 
		}
		
		if(((int)(q + t) / h) % 2 == 0) {
			q = (q + t) % h;
		}else {
			q = h - (q + t) % h; 
		}
		System.out.println(p + " " + q);
		
//		sb.append(p).append(" ").append(q);
//		System.out.println(sb);
	}
}

// 가로 w 세로 h 
// 초기 좌표 p,q
// 시간 t