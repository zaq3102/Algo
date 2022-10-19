package com.ssafy.day5.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @since 2021. 7. 7.
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<10; i++) {
            nums.add(i);
        }
        
        System.out.println("시작: "+nums);
        for(Integer num: nums) {
            if(num%2==0) {
                // nums.add(num*num);
                nums.remove(num);
                break;
            }
        }       
        
        
        Iterator<Integer> iter = nums.iterator();
        for(;iter.hasNext();) {
            if(iter.next()%2==0) {
                iter.remove();
            }
        }
        System.out.println("iter로 삭제 후");
        System.out.println(nums);
        
        nums.removeIf(num -> num%2==1);
        System.out.println("홀수로 삭제 후");
        System.out.println(nums);
        
    }
}
