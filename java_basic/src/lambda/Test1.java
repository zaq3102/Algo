package lambda;

/**
 * 람다의 기본 개념 - 인터페이스에 정의된 추상메서드가 한 개일 경우 사용 가능 (=Functional interface)
 */
public class Test1 {
	public static void main(String[] args) {
//		Sub01 sub01 = new Sub01(); // 추상메서드를 가지고 있어서, 객체 생성 불가
//		Sub01 sub1 = new ABC(); // 추상메서드의 바디를 완성해야 객체 생성 가능
		Sub01 sub1 = new Sub01() { // 익명클래스
			@Override
			public void call(String msg) {
				// TODO Auto-generated method stub
				System.out.println("메시지 : " + msg);
			}
		};
		
		sub1.call("안녕");

		Sub01 sub2 = (msg) -> {
			System.out.println("메세지 : " + msg);
		};
		
		sub2.call("hi");

		Sub01 sub3 = msg -> System.out.println("메세지 : " + msg);
		sub3.call("굿모닝");
	}
}

//class ABC implements Sub01{
//
//	@Override
//	public void call(String msg) {
//		// TODO Auto-generated method stub
//		System.out.println("메시지 : " + msg);
//	}
//	
//}

interface Sub01 {
	void call(String msg);

}
