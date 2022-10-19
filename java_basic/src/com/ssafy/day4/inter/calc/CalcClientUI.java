package com.ssafy.day4.inter.calc;

public class CalcClientUI {

	Calculator calc;
	
	public CalcClientUI(Calculator calc) {
		this.calc = calc;
	}
	
	public void add(int a, int b) {
		System.out.println(calc.add(a, b));
	}
	
}
