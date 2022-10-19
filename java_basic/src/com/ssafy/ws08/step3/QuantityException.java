package com.ssafy.ws08.step3;

/** 
 * 수량이 부족한 경우 발생하는 예외 클래스
 * */
public class QuantityException extends Exception{
	public QuantityException() {
		super("수량이 부족합니다. - 예외처리");
	}
}
