package com.ssafy.ws08.step3;

import com.ssafy.ws08.step3.Book;

public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체 생성
		BookManagerImpl BM = BookManagerImpl.getBookManager(); //new BookManager();
		System.out.println("************** 파일에서 불러온 도서 전체 목록 **************");
		Book[] books = BM.getList();
		
		if(books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else {
			for (Book book : books) {
				System.out.println(book);
				
			}
		}
		
//		// BookManager 객체를 이용해 도서 추가
		BM.add(new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법",10));
		BM.add(new Book("21425","Java Pro2","김하나","jaen.kr",25000,"Java 응용",20));
		BM.add(new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링",30));	
		
		BM.add(new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",40,2021,1));
		
		BM.saveData();
		
		
		
		
		
//		System.out.println("************** 도서 전체 목록 **************");
//
//		
//		for (Book book : BM.getList()) {
//			System.out.println(book);
//		}
//		
//		System.out.println("************** 일반 도서 목록 **************");
//		for (Book book : BM.getBooks()) {
//			if(book == null) {
//				break;
//			} else {
//				System.out.println(book);
//				
//			}
//		}
//		
//		System.out.println("************** 잡지 목록 **************");
//		for (Book book : BM.getMagazines()) {
//			if(book == null) {
//				break;
//			} else {
//				System.out.println(book);
//				
//			}
//		}
//		
//		System.out.println("************** 도서 제목 포함 검색 : Java **************");
//		BM.searchByTitle("Java");
//		for (Book book : BM.searchByTitle("Java")) {
//			System.out.println(book);
//		}
//		
//		System.out.println("도서 가격 총합 : " + BM.getTotalPrice());
//		System.out.println("도서 가격 평균 : " + BM.getPriceAvg());
//		
//		System.out.println("************** 도서판매: 21424, 11개 **************");
//		try {
//			BM.sell("21424", 11);
//		} catch (ISBNNotFoundException | QuantityException e) { // 두 예외를 한 번에 씀
//			System.out.println(e.getMessage());
//		}
//		System.out.println("************** 도서구매: 21424, 10개 **************");
//		try {
//			BM.buy("21424", 10);
//		} catch (ISBNNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(BM.searchByIsbn("21424"));
//		System.out.println("************** 도서판매: 21424, 11개 **************");
//		try {
//			BM.sell("21424", 11);
//		} catch (ISBNNotFoundException | QuantityException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(BM.searchByIsbn("21424"));

		
		
	}

}
