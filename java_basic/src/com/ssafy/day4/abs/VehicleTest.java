package com.ssafy.day4.abs;


public class VehicleTest {

	public static void main(String[] args) {
		// 여러 가지 운송 수단들을 관리해보자.
		
		Vehicle[] vehicles = {new DieselSUV(), new ElectricCar(), new HorseCart()};
		// Vehicle v = new Vehicle(); => X, 추상 클래스라서 객체 생성 할 수가 없다
		
		for (Vehicle v : vehicles) {
			v.addFuel();
			v.reportPosition();
		}
		
	}
}
