package com.ssafy.day5.exception.custom;

/**
 * @since 2021. 7. 7.
 */
public class UserExceptionTest {
    private static String[] fruits = {"사과", "오렌지", "토마토"};

    public static void main(String[] args) {
        boolean result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        // TODO: 2. getFruit2를 이용해서 오렌지 2개를 소비하시오.
        try {
        getFruit2("오렌지");
        getFruit2("오렌지");
        } catch (FruitNotFoundException e) {
        	e.printStackTrace();
        }
        // END:
        
        // TODO: 4. 수박, 멜론, 복숭아를 저장하시오.
        
        try {
			setFruit("수박");
			setFruit("멜론");
			setFruit("복숭아");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        // END:
        System.out.println("창고 관리 끝~");
    }

    private static boolean getFruit1(String name) {
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null && fruits[i].equals(name)) {
                fruits[i] = null;
                return true;
            }
        }
        return false;
    }

    // TODO: 1. getFruit1을 참조하여 예외를 활용하는 형태로 getFruit2를 작성하시오.
    private static boolean getFruit2(String name) throws FruitNotFoundException {
    	for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null && fruits[i].equals(name)) {
                fruits[i] = null;
                return true;
            }
        }
        // 실패한 경우 예외를 발생시키기. --> 전달
    	
//    	throw new FruitNotFoundException(name);
    	throw new FruitNotFoundException(name, fruits);
    	
    }
    
    // END:

    // TODO: 3. 배열의 null인 지점에 과일을 저장하도록 작성하시오.
    public static void setFruit(String name) {
    	for (int i = 0; i < fruits.length; i++) {
			if(fruits[i] == null) {
				fruits[i] = name;
				return;
			}
		}
    	throw new NoSpaceException(name);
    }
    
    
    // END:
}
