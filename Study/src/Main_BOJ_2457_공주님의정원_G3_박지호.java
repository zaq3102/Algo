import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_2457_공주님의정원_G3_박지호 {

	static class flower {
		Date start;
		Date end;
		long days;

		public flower(Date start, Date end, long days) {
			super();
			this.start = start;
			this.end = end;
			this.days = days;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<flower> G1 = new PriorityQueue<flower>();
		PriorityQueue<flower> G2 = new PriorityQueue<flower>();
		PriorityQueue<flower> G3 = new PriorityQueue<flower>();

		int N = Integer.parseInt(br.readLine()); // 꽃의 총 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String start = st.nextToken() + st.nextToken();
			String end = st.nextToken() + st.nextToken();
			
			Date temp_s = new SimpleDateFormat("MMdd").parse(start);
			Date temp_e = new SimpleDateFormat("MMdd").parse(end);
			long days = (temp_s.getTime() - temp_e.getTime()) / (24*60*60); // 꽃이 피어있는 날짜
			
			
			
		}

	}

}
// 시작일자가 3월 1일 이전 그룹 / 끝나는 일자가 11월 30일 이후 그룹 / 사이에 있는 그룹
// 30일 : 4 6 9 11
// 31일 : 3 5 7 8 10
//
// 3월 1일 ~ 11월 30일까지 배열을 만들고 true로 마킹해두자
//
// A : 끝나는 일자 기준으로 정렬해서 앞에서부터 선택하고 해당 종료 날짜에 가장 근접한 날짜 뽑는다?
// B : 가운데 그룹에서 가장 범위가 넓은 꽃 뽑고 해당 시작 끝 날짜 기준으로 양옆 그룹에서 뽑는다?

// 1. 첫 그룹에서 끝나는 일자 기준으로 정렬해서 가장 늦게 끝나는 꽃 선택
// 2. 두 번째 그룹에서 시작 일자 기준으로 정렬해서 가장 일찍 피는 꽃 선택
// 3. 세 번째 그룹에서 피어있는 일자 수가 큰 순서대로 정렬해서 하나씩 선택해가며 방문처리 
