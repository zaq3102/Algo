package lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {

		{
			List<String> names = Arrays.asList("서울", "광주", "대전", "구미", "부울경");
			System.out.println(1);
			System.out.println(names);
			Collections.sort(names, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) { // 정렬할 비교 기준

					return o1.compareTo(o2); // 오름차순
//					return o2.compareTo(o1); // 내림차순
				}
			});
			System.out.println(names);
		}
		
		{
			List<String> names = Arrays.asList("서울", "광주", "대전", "구미", "부울경");
			System.out.println(2);
			System.out.println(names);

			Collections.sort(names, (String o1, String o2) -> { // 정렬할 비교 기준
				return o1.compareTo(o2);

			});
			System.out.println(names);
		}
		
		{
			List<String> names = Arrays.asList("서울", "광주", "대전", "구미", "부울경");
			System.out.println(3);
			System.out.println(names);
			
//			Collections.sort(names, (String o1, String o2) -> o1.compareTo(o2));
//			Collections.sort(names, ( o1,  o2) -> o1.compareTo(o2));
//			Collections.sort(names, Collections.reverseOrder()); // 역순출력
			names.sort(Collections.reverseOrder());
			System.out.println(names);
		}

	}
}
