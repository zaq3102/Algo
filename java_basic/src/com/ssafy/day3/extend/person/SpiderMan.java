package com.ssafy.day3.extend.person;

public class SpiderMan extends Person { // is a 관계

	boolean isSpider;
	Spider spider = new Spider(); // has a 관계 => 멤버 변수를 통해 객체 생성 후 사용
	
	public SpiderMan(String name) {
		super(name);
		
	}
	
	// 생성자 오버로딩
	public SpiderMan() {
		this("Peter Parker"); // 위의 생성자 구문으로 이동
		
	}

	public void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
		} else {
			System.out.println("피터찌리릿!");
		}
	}

	// 메서드 재정의 : 자식 입장에 맞게 코드 개선
	public void jump() {

		if (isSpider) {
			spider.jump();
		} else {
			// System.out.println("피터쩜프!");
			super.jump();
		}

	}

}
