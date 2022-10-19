package com.ssafy.day5.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @since 2021. 7. 7.
 */
public class ListDeleteTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(rand.nextInt(20));
        }
        System.out.println("전체: " + nums);
        // TODO: 짝수인 요소들을 삭제해보자.
        for (int i = 0; i < nums.size(); i++) {
			if(nums.get(i)%2 == 0) {
				nums.remove(i);
				i--;
			}
		}
        // END:
        System.out.println("짝수 삭제 후: " + nums);

        // TODO: 홀수인 요소들을 삭제해보자.\
        for (int i = nums.size(); i >= 0; i--) {
			if(nums.get(i)%2 == 1) {
				nums.remove(i);
			}
		}
        
        // END:
        System.out.println("홀수 삭제 후: " + nums);
        
        List<String> strs = Arrays.asList("Hello", "Collection", "World");
        // TODO: strs에 자료를 추가, 수정, 삭제해보자.
        // END:
        System.out.println(strs);
    }

}
