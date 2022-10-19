package com.ssafy.day1;

/**
 * @since 2021. 7. 5.
 */
public class BP_30 {

    
    public static void main(String[] args) {
        // TODO: 지정한 출력을 처리하시오.
        // END:
    	
    	for(int i = 0; i <5; i++) {
    		for(int j = 0; j < i; j++) {
    			System.out.print(" ");
    		}
    		for(int j = 9-2*i; j > 0; j--) {
    			System.out.print("#");
    		}
    		System.out.println();
    	}
    }

}
