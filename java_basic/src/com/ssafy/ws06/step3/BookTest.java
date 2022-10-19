package com.ssafy.ws06.step3;

import com.ssafy.ws06.step3.Book;

public class BookTest {

	public static void main(String[] args) {
		
//		Book b2 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		
		
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체 생성
		BookManagerImpl BM = BookManagerImpl.getBookManager(); //new BookManager();
		
		// BookManager 객체를 이용해 도서 추가
		BM.add(new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법"));
		BM.add(new Book("21425","Java Pro2","김하나","jaen.kr",25000,"Java 응용"));
		BM.add(new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링"));	
		
		BM.add(new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",2021,1));
		
		System.out.println("************** 도서 전체 목록 **************");
//		Book[] BL = new Book[5];
//		BL = BM.getList();
		
//		for (int i = 0; i < BL.length; i++) {
//			if(BL[i] == null) {
//				break;
//			} else {
//				System.out.println(BL[i]);
//			}
//		}
		
		for (Book book : BM.getList()) {
			System.out.println(book);
		}
		
		System.out.println("************** 일반 도서 목록 **************");
		for (Book book : BM.getBooks()) {
			if(book == null) {
				break;
			} else {
				System.out.println(book);
				
			}
		}
		
		System.out.println("************** 잡지 목록 **************");
		for (Book book : BM.getMagazines()) {
			if(book == null) {
				break;
			} else {
				System.out.println(book);
				
			}
		}
		
		System.out.println("************** 도서 제목 포함 검색 : Java **************");
		BM.searchByTitle("Java");
		for (Book book : BM.searchByTitle("Java")) {
			System.out.println(book);
		}
		
		System.out.println("도서 가격 총합 : " + BM.getTotalPrice());
		System.out.println("도서 가격 평균 : " + BM.getPriceAvg());
		
//		Book result = BM.searchByIsbn("21424");
//		System.out.println("**************도서조회:" + 21424 + "**************");
//		if(result == null) {
//			System.out.println("비어있습니다.");
//		}else {
//			System.out.println(result);
//		}
//		
//		
//		BM.remove("21424");
//		
////		BL = BM.getList();
//		System.out.println("**************도서목록**************");
//		for (Book book : BM.getList()) {
//			System.out.println(book);
//		} 
		
//		for (int i = 0; i < BL.length; i++) {
//			if(BL[i] == null) {
//				break;
//			} else {
//				System.out.println(BL[i]);
//			}
//		} // 이건 내가 짠거
		
		
	}

}
