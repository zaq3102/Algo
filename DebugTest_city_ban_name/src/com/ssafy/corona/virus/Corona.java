package com.ssafy.corona.virus;

public class Corona extends Virus{
	public int spreadSpeed;

	public Corona() {	}

	
	
	public Corona(String name, int level, int spreadSpeed) {
		super(name, level);
		this.spreadSpeed = spreadSpeed;
	}



	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}
}