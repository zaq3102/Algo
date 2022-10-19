package com.ssafy.ws03.step3;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		
		Book b1 = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법");
		Book b2 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		
		System.out.println("************************* 도서목록 *************************");
		System.out.println(b1.toString());
		System.out.println(b2.toString()); //toString 생략하면 b2 주소지 리턴
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		System.out.println("******************도서목록********************");
		Book book1 = new Book();
		book1.isbn ="21421";
		book1.title = "java pro";
		book1.author = "홍길동";
		book1.publisher ="싸피";
		book1.price = 1000;
		book1.disc = "자바의 정석";
		
		Book book2 = new Book("32123", "분석설계", "김싸피", "싸피출판사", 30000, "분석 설계");
		
		System.out.println(book1.isbn + "\t |"+book1.title + "\t |"+book1.author +
				"\t |"+book1.publisher + "\t |"+book1.price + "\t |"+book1.disc );
		
		System.out.println(book2.toString());
		*/
		
	}
}

