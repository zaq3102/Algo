package com.ssafy.ws07.step3;

import java.util.ArrayList;
import java.util.List;

/** 도서 리스트를 배열로 유지하며 관리하는 클래스 */
public class BookManagerImpl implements IBookManager {

	/** 관리할 일반 도서 리스트 */
	private List<Book> books = new ArrayList<Book>(100);

	// 여기서부터 싱글톤 패턴!
	private static BookManagerImpl bookManager = new BookManagerImpl();

	private BookManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public static BookManagerImpl getBookManager() { // 여길 static으로 써줌으로써 BookTest에서 객체 참조로 인한 변경이 없다.
		return bookManager; // 이것이 바로 싱글톤 디자인 패턴!
	}

	/** 도서정보 등록 */
	@Override
	public void add(Book book) {
		books.add(book);
	}

	/** 도서정보 삭제 */
	@Override
	public void remove(String isbn) {

		for (int i = books.size() - 1; i >= 0; i--) { // 효율적인 사이즈 참조 코드
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}

		System.out.println("**************도서삭제:" + isbn + "**************");
	}

	/** 도서리스트 반환 */
	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	/** 검색결과 반환 */
	@Override
	public Book searchByIsbn(String isbn) {

		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}

		return null;


	}

	/** 제목을 포함검색 처리 후 도서 리스트 반환 */
	@Override
	public Book[] searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<Book>();

		for (Book book : books) {
			if (book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		Book[] result = new Book[temp.size()];
		
		return temp.toArray(result);

	}

	/** 일반 도서목록 반환 */
	@Override
	public Book[] getBooks() {

		List<Book> temp = new ArrayList<Book>();

		for (Book book : books) {
			if (!(book instanceof Magazine)) {
				temp.add(book);
			}
		}

		Book[] result = new Book[temp.size()];

		return temp.toArray(result);

	}

	/** 잡지 목록 반환 */
	@Override
	public Magazine[] getMagazines() {
		List<Magazine> temp = new ArrayList<Magazine>();

		for (Book book : books) {
			if ((book instanceof Magazine)) {
				temp.add((Magazine)book);
			}
		}

		Magazine[] result = new Magazine[temp.size()];

		return temp.toArray(result);

	}

	/** 총액 계산 */
	@Override
	public int getTotalPrice() {
		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;

	}

	/** 금액 평균 */
	@Override
	public double getPriceAvg() {
		return (double) getTotalPrice() / books.size();
	}

	/** 판매 
	 * @throws ISBNNotFoundException */
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		Book book = searchByIsbn(isbn);
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		} 
		
		int result = book.getQuantitiy() - quantity;
		if(result < 0) {
			throw new QuantityException();
		}
		
		book.setQuantitiy(result);

	}

	/** 구매 
	 * @throws ISBNNotFoundException */
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);
		
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		
		book.setQuantitiy(book.getQuantitiy() + quantity);


	}

}
