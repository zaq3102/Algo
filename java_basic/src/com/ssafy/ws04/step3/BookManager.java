package com.ssafy.ws04.step3;

import java.util.Arrays;

import com.ssafy.ws04.step3.Book;

/** 도서 리스트를 배열로 유지하며 관리하는 클래스 */
public class BookManager {
	/** 관리할 최대 도서 수 */
	private final int MAX_SIZE = 100;
	/** 관리할 도서 리스트 */
	private Book[] books = new Book[MAX_SIZE];
	/** 현재 등록된 도서 수 */
	private int size = 0;

//	Book b1 = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법");
//	Book b2 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");

//	books[0] = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법");

	/** 도서정보 등록 */
	public void add(Book book) {
		if(size < MAX_SIZE) { // 꽉 차지 않은 경우에만 
			books[size++] = book; //size++을 따로 쓰지 않고 한 줄 안에 넣어버림
			
		}
	}

	/** 도서정보 삭제 */
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				//i 번째 책 제거, 맨 뒤의 책을 i번째로 이동, 맨 뒤의 책은 삭제
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
				
				
				
			}
		}
		

//		for (int i = 0; i < books.length; i++) {
//			if (books[i].getIsbn() == isbn) {
//				books[i] = null;
//				break;
//			}
//		} // 이건 내가 만든거

		System.out.println("**************도서삭제:" + isbn + "**************");
	}

//	/** 도서정보 반환 */
//	public Book[] getList() {
//		int cnt = 0;
//		Book[] books_copy = new Book[MAX_SIZE];
//
//		for (int i = 0; i < books.length; i++) {
//			if (books[i] == null) {
//				continue;
//			} else {
//				books_copy[cnt] = books[i];
//				cnt++;
//			}
//		}
//
//		return books_copy;
//
//	} //이건 내가 만든 거
	
	
	public Book[] getList() {
		
		return Arrays.copyOfRange(books, 0, size); // 편리는 하지만 array copy보다 느리다
		
//		Book[] bookCopy = new Book[size];
//		for (int i = 0; i < b.length; i++) {
//			b[i] = books[i];
//		}
		
//		System.arraycopy(books, 0, bookCopy, 0, size); // 위와 똑같은 작업이지만 빠르다, 단 복사 배열 미리 생성해야함
//		return bookCopy;
	}

	/** 검색결과 반환 */
	public Book searchByIsbn(String isbn) {

		for (int i = 0; i < size; i++) {
			if (books[i].
					getIsbn().
					equals(isbn)) { // 이런식으로 하면 어디서 에러인지 한 번에 안다
				return books[i];
			}
		}
		return null;

	}

}
