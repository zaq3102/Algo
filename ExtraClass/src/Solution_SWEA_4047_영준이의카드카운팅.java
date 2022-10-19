import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_SWEA_4047_영준이의카드카운팅 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) {

			String s = sc.next();
			Map<Character, ArrayList<Integer>> map = new HashMap<>();
			map.put('S', new ArrayList<Integer>());
			map.put('D', new ArrayList<Integer>());
			map.put('H', new ArrayList<Integer>());
			map.put('C', new ArrayList<Integer>());
			boolean flag = true;
			for (int i = 0; i < s.length(); i += 3) {
				char type = s.charAt(i);
				int num = Integer.parseInt(s.substring(i + 1, i + 3)); // 앞의 자리는 포함, 뒤의 자리는 미포함
				ArrayList<Integer> deck = map.get(type);
				if (deck.contains(num)) { // 실패
					flag = false;
					break;
				}
				deck.add(num);
			}
			// 성공
			if (flag) {
				System.out.printf("#%d %d %d %d %d\n", testCase, 13 - map.get('S').size(), 13 - map.get('D').size(),
						13 - map.get('H').size(), 13 - map.get('C').size());
			} else {
				System.out.println("#" + testCase + " ERROR");
			}
		}

	}

}
