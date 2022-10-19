/** 
 * main메서드가 있는, Mart 클래스 활용할 클래스
 * 
 * */


public class MartTest {
	public static void main(String[] args) {
//		Mart m1 = new Mart();
//		
//		m1.name = "홈플러스";
//		m1.ball = 10000;
//		m1.pen = 2000;
//		
		Mart m2 = new Mart();
		m2.name = "이마트";
		m2.ball = 15000;
		m2.pen = 2500;

		Mart m1 = new Mart("홈플러스", 10000, 2000);
//		Mart m2 = new Mart("이마트", 15000, 2500);
		
		
		m1.sale();
		m2.sale();
		System.out.println(m1.printMart());
		System.out.println(m2.printMart());

		
	} //end of main
} //end of class
