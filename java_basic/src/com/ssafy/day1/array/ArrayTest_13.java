package com.ssafy.day1.array;

/**
 * @since 2021. 7. 6.
 */
public class ArrayTest_13 {
    public static void main(String[] args) {
        int[] intArray = {1, 3, 4, 7, 8, 10, 12, 15, 16, 17, 18};
        int[] used = new int[21];
        // TODO: 1~20까지의 숫자 중 intArray에서 사용되지 않은 숫자를 출력하세요.
        // END:
        
        for(int i = 0; i < intArray.length; i++) {
        	
        	used[intArray[i]]++;
        	
        }
        
        for(int j = 0; j < used.length; j++) {
        	if(used[j] == 0) {
        		System.out.print(j + " ");
        	}
        }
    }
}
