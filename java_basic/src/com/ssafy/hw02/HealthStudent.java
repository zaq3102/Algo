package com.ssafy.hw02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthStudent {

	// ssafy-Health 학원생의 건강정보를 관리하기 위해 이름, 측정 일자와 몸무게(kg)로 구성된 클래스를 구현
	String name;
	Date date;
	double weight;
	double height;
	
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

	public HealthStudent() {
		// TODO Auto-generated constructor stub
	}

	public HealthStudent(String name, Date date, double weight, double height) {
		super();
		this.name = name;
		this.date = date;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return name + "  " + transFormat.format(date) + "  " + weight + "  " + height;
	}

	
	 

}
