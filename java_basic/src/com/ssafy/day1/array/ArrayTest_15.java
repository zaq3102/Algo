package com.ssafy.day1.array;

/**
 * @since 2021. 7. 6.
 */
public class ArrayTest_15 {
    public static void main(String[] args) {
        // TODO: 문제에서 제시하는 2차원 배열을 생성하고 내용을 출력하시오.
        // END:
    	
    	char[][] arr = new char[][] {{'C','A','A'},{'C','C','B'},{'B','A','B'},{'C','C','C'}};
    	
    	for(char[] chars: arr) {
    		for(char c : chars) {
    			System.out.print(c);
    			
    		}
    		System.out.println();
    		
    	}
    }
}
