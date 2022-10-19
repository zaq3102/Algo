package com.ssafy.day1;

import java.util.Random;

/**
 * @since 2021. 7. 5.
 */
public class BP_23 {
    public static void main(String[] args) {
    	int sum = 0;
        int cnt = 100;
        double avg = 0;
        Random rand = new Random();
        
        // TODO: 주사위를 100번 던진 결과의 합과 평균을 출력하시오. for 문 활용
        // END:
        
        for(int i = 0; i < cnt; i++) {
        	sum += rand.nextInt(6) + 1; //rand.nextInt(6) : 0~5까지 랜덤
        }
        avg = 1.0*sum/cnt; // sum, cnt 모두 int형이므로 1.0 곱해서 double형으로 자동 변환
        
        System.out.printf("sum: %d, avg: %f%n", sum, avg);
    }
}
