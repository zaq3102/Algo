package com.ssafy.ws05.step3;

import java.util.Arrays;
import com.ssafy.ws05.step3.Book;

/** 도서 리스트를 배열로 유지하며 관리하는 클래스 */
public class BookManager {
	/** 관리할 최대 도서 수 */
	private final int MAX_SIZE = 100;
	/** 관리할 일반 도서 리스트 */
	private Book[] books = new Book[MAX_SIZE];
	
//	/** 관리할 잡지 리스트 */
//	private Magazine[] MZ = new Magazine[MAX_SIZE];
	
	/** 현재 등록된 도서 수 */
	private int size = 0;

	//여기서부터 싱글톤 패턴!
	private static BookManager bookManager = new BookManager();
	private BookManager() {
		// TODO Auto-generated constructor stub
	}
	public static BookManager getBookManager() { // 여길 static으로 써줌으로써 BookTest에서 객체 참조로 인한 변경이 없다.
		return bookManager;						 // 이것이 바로 싱글톤 디자인 패턴!
	}
	
	
	
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

		System.out.println("**************도서삭제:" + isbn + "**************");
	}

	
	
	public Book[] getList() {
		
		return Arrays.copyOfRange(books, 0, size); // 편리는 하지만 array copy보다 느리다
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
	
	
	/** 제목을 포함검색 처리 후 도서 리스트 반환 */
	public Book[] searchByTitle(String title) {
		int cnt = 0; // 검색한 도서의 개수
		for (int i = 0; i < size; i++) {
			if(books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				cnt++;
			}
		}
		Book[] result = new Book[cnt];
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if(books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
				result[idx++] = books[i];
			}
		}
		return result;
		
	}
	/** 일반 도서목록 반환 */
	public Book[] getBooks() {
		int cnt = 0; // 잡지가 아닌 도서의 개수 카운터
		for (int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) { // 잡지가 아닌 도서이면
					cnt++;
				// books[0] 가 Magazine 타입인가 판별
			}
		}
		
		Book[] result = new Book[size];
		for (int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) { // 잡지가 아닌 도서이면
					result[--cnt] = books[i];
			}
		}

		return result;
	}
		
		
	
	/** 잡지 목록 반환 */
	public Book[] getMagazines() {
		int cnt = 0; // 잡지가 아닌 도서의 개수 카운터
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) { // 잡지도서이면
					cnt++;
				// books[0] 가 Magazine 타입인가 판별
			}
		}
		
		Magazine[] result = new Magazine[size];
		for (int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) { // 잡지도서이면
					result[--cnt] = (Magazine)books[i];
			}
		}

		return result;
		
		
		
	}
	/** 총액 계산 */
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += books[i].getPrice();
		}
		return total;
		
		
	}
	/** 금액 평균 */
	public double getPriceAvg() {
		return (double)getTotalPrice() / size;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
