package com.ssafy.ws10.step3.weather;

public class Weather {
	private String hour;
	private String temp;
	private String wfKor;
	private String ref;

	public Weather() {
		super();
	}

	public Weather(String hour, String temp, String wfKor, String ref) {
		super();
		setHour(hour);
		setTemp(temp);
		setWfKor(wfKor);
		setReh(ref);
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String getReh() {
		return ref;
	}

	public void setReh(String reh) {
		this.ref = reh;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("시간: ");
		builder.append(hour + "시");
		builder.append("     ");
		builder.append("온도: ");
		builder.append(temp + "도");
		builder.append("     ");
		builder.append("구름양: ");
		builder.append(wfKor);
		builder.append("     ");
		builder.append("습도: ");
		builder.append(ref + "%");
		return builder.toString();
	}
}
