package com.ssafy.day5.exception.custom;

import java.util.Arrays;

/**
 * @since 2021. 7. 8.
 */
public class FruitNotFoundException extends Exception {
    public FruitNotFoundException(String name) {
    	// Exception의 생성자에 메세지 전달
        super(name + "에 해당하는 과일은 없습니다.");
    }
    
    public FruitNotFoundException(String name, String[] fruits) {
    	this(name);
    	System.out.println("현재 재고 : " + Arrays.toString(fruits));
    	
    	
    }
}
