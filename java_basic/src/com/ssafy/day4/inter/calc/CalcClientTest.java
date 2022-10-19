package com.ssafy.day4.inter.calc;

public class CalcClientTest {
	public static void main(String[] args) {
		
		
		
		Calculator calc = new CalculatorImpl();
		CalcClientUI ui = new CalcClientUI(calc);
		
		ui.add(100, 200);
	}
}
