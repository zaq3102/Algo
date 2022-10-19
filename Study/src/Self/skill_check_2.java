package Self;

import java.util.StringTokenizer;

public class skill_check_2 {
	public static void main(String[] args) {
//		String m = "ABCDEFG";
//		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };

//		String m = "CC#BCC#BCC#BCC#B";
//		String[] musicinfos = { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" };

		String m = "ABC";
		String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		System.out.println(solution(m, musicinfos));
	}

	public static String solution(String m, String[] musicinfos) {
		StringTokenizer st = null;
		String result_name = null;
		int result_time = 0;

		for (int i = 0; i < musicinfos.length; i++) {
			st = new StringTokenizer(musicinfos[i], ",");

			String s_t = st.nextToken();
			int s_h = (s_t.charAt(0) - '0') * 10 + (s_t.charAt(1) - '0');
			int s_m = (s_t.charAt(3) - '0') * 10 + (s_t.charAt(4) - '0');

			String e_t = st.nextToken();
			int e_h = (e_t.charAt(0) - '0') * 10 + (e_t.charAt(1) - '0');
			int e_m = (e_t.charAt(3) - '0') * 10 + (e_t.charAt(4) - '0');

			int diff = (e_h - s_h) * 60 + (e_m - s_m);

			String name = st.nextToken();
			String info = st.nextToken();

			String radio_info = ""; // 시간이 적용된 악보

			int sharp = 0;
			for (int j = 0; j < info.length(); j++) {
				if (info.charAt(j) == '#') {
					sharp++;
				}
			}

			if (info.length() - sharp > diff) { // 완곡 전에 끊긴다
				int cnt = 0;
				for (int j = 0; j < info.length(); j++) {
					if (cnt == diff) {
						break;
					}

					radio_info += info.charAt(j);
					if (info.charAt(j) == '#') {
						cnt--;
					}

					cnt++;
				}

			} else if (info.length() - sharp == diff) { // 딱 끝남
				radio_info = info;
			} else { // 추가로 더한다
				int rep = diff / (info.length() - sharp);
				int les = diff % (info.length() - sharp);

				for (int j = 0; j < rep; j++) {
					radio_info += info;
				}

				int cnt = 0;
				for (int j = 0; j < info.length(); j++) {
					if (cnt == les) {
						break;
					}

					radio_info += info.charAt(j);
					if (info.charAt(j) == '#') {
						cnt--;
					}

					cnt++;
				}

			}

			if (radio_info.contains(m)) {

				if (result_name == null) { // 처음 매칭
					result_name = name;
					result_time = diff;
				} else {
					if (diff > result_time) {
						result_name = name;
						result_time = diff;
					}
				}

			}

		}

		String answer = result_name;
		return answer;
	}

}
