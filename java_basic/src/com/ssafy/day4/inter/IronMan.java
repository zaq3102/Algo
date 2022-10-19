package com.ssafy.day4.inter;

public class IronMan implements Heroable{

	@Override
	public int fire() {
		System.out.println("발사!");
		return 0;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		System.out.println("변신!");
		
	}

	@Override
	public void upgrade() {
		System.out.println("기능 강화!");
		
	}
	
}
