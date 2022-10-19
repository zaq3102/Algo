package com.ssafy.day5.exception.custom;

public class NoSpaceException extends RuntimeException {
	public NoSpaceException(String name) {
		// TODO Auto-generated constructor stub
		super(name + " 을 넣을 공간이 없습니다.");
	}
}
