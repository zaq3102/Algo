package com.ssafy.day4.generic.box;

/**
 * @since 2021. 7. 7.
 */
public class UseBoxTest {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        useNormalBox();
         useGenericBox();
    }
    
    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox box = new NormalBox();
    	box.setSome("Hello");
    	box.setSome(1);
    	
    	Object some = box.getSome();
    	// 런타임에 타입에 대한 체크 진행
    	if(some instanceof Integer) {
    		Integer val = (Integer)some;
    		System.out.println(val.intValue());
    	}
        // END:
    }
    
    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> gbox = new GenericBox<>();
    	gbox.setSome("Hello");
    	
    	// 컴파일 타임에 타입 체크 완료
    	String some = gbox.getSome();
    	System.out.println(some.length());
    	
    	GenericBox<Integer> ibox = new GenericBox<>();
    	ibox.setSome(1);
    	System.out.println(ibox.getSome());
    	
    	GenericBox<Object> obox = new GenericBox<>();
    	
    	
        // END:
    }
    
    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

}
