package com.ssafy.day1.array;

/**
 * @since 2021. 7. 5.
 */
public class ArrayTest_05 {
    public static void main(String[] args) {
        String org = "1234567890";
        // TODO: String "1234567890" 의 자리 별 수를 1차원 배열에 저장하고 배열을 순회해서 그 합을 출력하시오.
        // END:
        int sum = 0;
        int[] arr_int = new int[org.length()];
        
        
        for (int i = 0; i < arr_int.length; i++) {
        	arr_int[i] = org.charAt(i);
        	
		}
        
        for (int j = 0; j < arr_int.length; j++) {
			int k = arr_int[j]-'0';
			sum += k;
		}
        
        System.out.println(sum);
    }
}
