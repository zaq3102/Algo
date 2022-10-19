package lambda;

public class Test2 {
	public static void main(String[] args) {
		//sub1,2,3 모두 동일한 의미
		Sub02 sub1 = new Sub02() { // 익명클래스

			@Override
			public int power(int val) {
				// TODO Auto-generated method stub
				return val * val;
			}
		};
		System.out.println(sub1.power(9));
		
		Sub02 sub2 = (val) -> {
			return val * val;
		};
		System.out.println(sub2.power(9));
		
		Sub02 sub3 = val -> val*val;
		System.out.println(sub3.power(9));
		
	}
}

interface Sub02 {
	int power(int val);
}
