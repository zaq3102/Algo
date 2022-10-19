/**
 * 클래스 연습, 마트 : 이마트, 홈플러스 
 * 변수 : 마트이름, 공, 펜
 * 메서드 : 상태정보 출력, 세일메서드
 * */
public class Mart {
	/** 마트 이름*/
	String name;
	
	/** 공의 가격*/
	int ball;

	/** 펜의 가격*/
	int pen;
	
	//Ctrl + Space : 맨땅에 기본생성자 생성 
	public Mart() {
		// TODO Auto-generated constructor stub
	}
	
	// Alt + Shift + s -> O : 생성자 생성 단축키
	public Mart(String name, int ball, int pen) {
			super();
			this.name = name;
			this.ball = ball;
			this.pen = pen;
		}

//	Mart() {
//		this("콩클러스", 1000, 100); // 아래 this를 이용한 생성자 쪽으로 호출
//	}
//	
//	// 참조의 기본 원칙 : 호출하는 곳에서 가까운 곳에 선언된 것을 우선 참조한다
//	// 모든 클래스는 반드시 하나 이상의 생성자가 존재해야 한다.
//	// 생성자가 하나도 없으면, 컴파일러가 기본 생성자를 추가해준다.
//	// 생성자를 작성하면, 더 이상 기본 생성자를 추가해주지 않는다. 
//	
//	
//	
//	// this : 나 자신의 객체를 가리키는 참조 변수
//	// this() : 나 이외의 또 다른 생성자를 호출
//	//			반드시 생성자 함수의 첫 줄에 작성해야 한다.
//	//			모든 생성자는 나 말고 다른 생성자를 호출해야 한다.
//	//			아무것도 호출하지 않으면, 컴파일러가 super(); 호출
//	
//	Mart(String name, int ball, int pen) {
//		this.name = name;
//		this.ball = ball;
//		this.pen = pen;
//		
//	}
	

	/** 마트의 정보를 문자열로 리턴하는 메서드*/
	String printMart() {
		return name + ", " + ball + "원, " + pen + "원";
		
		
	}
	
	/** 마트의 모든 제품을 10% 세일하는 메서드 */
	void sale() {
		ball = (int)(ball * 0.9);
		pen *= 0.9;
	}
	
}
