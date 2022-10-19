package com.ssafy.ws03.step3;
/**
 * 도서 정보를 나타내는 클래스
 */
/**
 * @author 지호
 *
 */
public class Book {
	/** 고유 번호 */
	String isbn;
	/** 제목 */
	String title;
	/** 저자 */
	String author;
	/** 출판사*/
	String publisher;
	/** 가격*/
	int price;
	/** 설명*/
	String desc;
	
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

	@Override
	public String toString() {
		return isbn + "\t|" + title + "\t|" + author + "\t|" + publisher
				+ "\t|" + price + "\t|" + desc;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	String isbn;
	String title;
	String author;
	String publisher ;
	int price;
	String disc;
	
	Book(){
		
	}

	public Book(String isbn, String title, String author, String publisher, int price, String disc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.disc = disc;
	}
	
	public String toString(){
		return this.isbn + "\t |"+ title + "\t |"+author +
				"\t |"+publisher + "\t |"+price + "\t |"+disc; 
	}
	
	*/
	
	
	
//	Book(String isbn,String title){
//		this.isbn = isbn;
//		this.title = title;
//	}
}

