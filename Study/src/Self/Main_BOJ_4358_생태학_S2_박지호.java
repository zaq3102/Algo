package Self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_BOJ_4358_생태학_S2_박지호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int total = 0;
		String input = "";

		while (true) {
			input = br.readLine();
			if (input == null || input.equals("")) {
				break;
			}

			total++;
			if (map.containsKey(input)) { // 이미 있는 요소라면
				map.put(input, map.get(input) + 1);
			} else { // 처음 들어가는 요소라면
				map.put(input, 1);
			}
		}

		// 해시맵의 키값을 스트링으로 가져와서(=keyset) 배열로변환(=toArray)
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);

		for (int i = 0; i < mapkey.length; i++) {
			double temp = ((double) map.get(mapkey[i]) / (double) total) * 100;
			double result = Math.round(temp * 10000) / 10000.0;

			System.out.println(mapkey[i] + " " + result);
		}

//		Scanner scan = new Scanner(System.in);
//
//		HashMap<String, Integer> map = new HashMap<>();
//		int count = 0;
//
//		while (scan.hasNextLine()) {
//			String str = scan.nextLine();
//			map.put(str, map.getOrDefault(str, 0) + 1);
//			count++;
//		}
//
//		Object[] keyArr = map.keySet().toArray(); // 키 값을 배열로 받아옴
//		Arrays.sort(keyArr);
//
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < keyArr.length; i++) {
//			int value = map.get(keyArr[i]);
//			double percent = ((double) value / (double) count) * 100;
//			sb.append(keyArr[i] + " " + String.format("%.4f", percent) + "\n");
//		}
//		System.out.println(sb.toString());

	}
}
