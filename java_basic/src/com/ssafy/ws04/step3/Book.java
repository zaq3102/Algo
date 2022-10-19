package com.ssafy.ws04.step3;

public class Book {
// 캡슐화 기본 원칙 : 외부 접근 차단 => private 접근 제어자 사용 (빨간 네모)
	/** 고유 번호 */
	private String isbn;
	/** 제목 */
	private String title;
	/** 저자 */
	private String author;
	/** 출판사*/
	private String publisher;
	/** 가격*/
	private int price;
	/** 설명*/
	private String desc;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn + "\t|" + title + "\t|" + author + "\t|" + publisher
				+ "\t|" + price + "\t|" + desc;
	}
	
	public String test() {
		return "test";
		
	}
	

}
