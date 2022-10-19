package com.ssafy.day4.inter.relation;

/**
 * @since 2021. 7. 7.
 */
public class HandPhone extends Phone implements Chargeable{

	@Override
	public void charge() {
		System.out.println("핸드폰 충전 중...");
		
	}
    // TODO: Chargeable을 구현하시오.
    // END:
}
