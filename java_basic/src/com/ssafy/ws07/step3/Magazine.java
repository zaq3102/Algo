package com.ssafy.ws07.step3;

/**
 * 잡지 정보를 나타내는 클래스
 */
public class Magazine extends Book {
	// 변수 메서드 클래스 하이라이트 후 Alt + Shift + j : Document Comment
	/** 연도*/
	private int year;
	/** 월*/
	private int month;
	
	public Magazine() {
		// 아무것도 안쓰면 super(); 가 생략되어 있다
	}
	

	// Alt + Shift + S 후 매개변수가 존재하는 생성자 클래스 선택
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantitiy, int year,
		int month) {
	super(isbn, title, author, publisher, price, desc, quantitiy);
	
	this.year = year;
	this.month = month;
}



	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}


	@Override
	public String toString() {
		return super.toString() + "|\t" + year + "|\t" + month; //부모의 toString 참조
	}




	
	

	
	
	
	

}
