package apple;

import java.util.Arrays;

/** 문자열 관련 유용한 클래스 */
public interface StringTest {
	public static void main(String[] args) {
		String s1 = new String("aBcDeFgHiJ"); //Heap
		String s2 = new String("aBcDeFgHiJ"); //s1과 s2는 주소가 같을 수 없다!
		String s3 = "aBcDeFgHiJ"; // ConstantPool = 상수풀, 문자열 재활용
		String s4 = "aBcDeFgHiJ"; // s3주소 = s4주소
		
		System.out.println(s1);
		System.out.println(s1.toString()); // 위와 동일
		System.out.println("문자열 길이 : " + s1.length());
		System.out.println("2번째 글자 : " + s1.charAt(2)); // 0번지부터 시작
		System.out.println("이어붙여줌 : " + s1.concat("xyz")); // String 관련 메서드 결과는 해당 라인에만 리턴됨 => 원본은 변경 X
		System.out.println("값 변경 : " + s1.replace("aBc", "xyz")); // xyzDeFgHiJ
		System.out.println("소문자 : "+s1.toLowerCase());
		System.out.println("대문자 : "+s1.toUpperCase());
		System.out.println("포함 여부 : " + s1.contains("DeF"));
		System.out.println("위치 찾기 : " + s1.indexOf("DeF")); // 처음부터 찾기
		System.out.println("위치 찾기 : " + s1.indexOf("DeF", s1.indexOf("DeF")+1)); // 다음꺼 찾기
		System.out.println("공백 제거 : " + "   \t\t\n\n안녕\n\n\t\t  ".trim()); // 앞뒤의 화이트 스페이스 제거
		System.out.println(s1.equals("abcdefghij")); // False
		System.out.println(s1.equalsIgnoreCase("abcdefghij")); // 대소문자구별X, True
		System.out.println(s1.substring(4)); // i번째부터 끝까지 출력
		System.out.println(s1.substring(4,7)); // (포함, 미포함)
		
		System.out.println("원본은 안바뀜 : " + s1);
		
		char[] crr = s1.toCharArray();
		System.out.println(Arrays.toString(crr)); // [a, B, c, D, e, F, g, H, i, J]
		
		
		String s = "a,b,c,ddd,"; // 앞의 , 는 원소를 구분하지만 뒤의 , 는 무시해준다
		String[] srr = s.split(",");
		System.out.println(Arrays.toString(srr));
		
		System.out.println("///////////////////////////////////");
		// 문자열 성능 개선 StringBuilder, StringBuffer
		// StringBuilder : 싱글쓰레드 용, 빠르다
		// StringBuffer	 : 멀티쓰레드 용, 느리다
		
		StringBuilder sb = new StringBuilder(s1);
		System.out.println(sb.substring(2,5));
		System.out.println(sb.length()); // 10
		System.out.println(sb.capacity()); // 만들어진 공간 수 26 = 10 + 16
		System.out.println(sb.append("xyz")); // 원본도 바뀐다.
		sb.append("#").append(1).append(" ").append(300); // 연달아 쓰기 가능
		
		System.out.println("역순 : " + sb.reverse()); // 역순
		
		System.out.println("#" + 3 + " " + 800);
		System.out.println(new StringBuilder("#").append(3).append(" ").append(800));
		//두 문장은 똑같으나 StringBuilder 를 사용하는 것이 훨씬 효율적
		
	}

}
