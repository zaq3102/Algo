package com.ssafy.hw08.step2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Main {

	public static void main(String arg[]) throws FileNotFoundException {

		File path = new File("C:\\SSAFY\\01_java\\java_basic\\src\\com\\ssafy\\hw08\\step2\\fileout_hw02.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(path));) {

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
