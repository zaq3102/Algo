package com.ssafy.hw04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exchanger {

	public static void main(String[] args) throws FileNotFoundException {
		String path = Exchanger.class.getResource("").getPath() + "input.txt";
		Scanner sc = new Scanner(new File(path));

		for (int i = 0; i < 2; i++) {
			if (sc.hasNextLine()) { 
				String line = sc.nextLine(); // 한줄씩 받아서
				String[] money = line.split(","); // , 단위로 구분

				if (money[0].equals("KRW")) {
					toDollar(money[1]);
				} else if (money[0].equals("USD")) {
					toKRW(money[1]);
				} else {
					System.out.println("SOMETHING WRONG!");
				}
			} else {
				break;
			}
		}
	}

	public static void toDollar(String m) {
		double a = Double.parseDouble(m) / (1100);
		System.out.printf("%s원 >> %.2f달러\n", m, a);
	}

	public static void toKRW(String m) {
		double a = (1.1)*Double.parseDouble(m);
		DecimalFormat dec = new DecimalFormat("###,###"); // 형식 지정
		String dec_won = dec.format((int)a);
		System.out.printf("%s달러 >> %s원\n", m, dec_won);
	}
}
