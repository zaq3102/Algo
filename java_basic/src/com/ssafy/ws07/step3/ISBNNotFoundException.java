package com.ssafy.ws07.step3;

public class ISBNNotFoundException extends Exception {
	private String isbn;

	public ISBNNotFoundException(String isbn) {
		super(isbn + "이 존재하지 않습니다. - 예외처리");
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

}
