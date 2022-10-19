package test;

public class testDto {
	private int trnscCost; // 거래금액
	private int cnstrYear; // 년
	private int trnscYear; // 거래년도
	private String roadName; // 도로명
	private String roadMainCode; // 도로명건물본번호코드
	private String roadSubCode; // 도로명건물부번호코드
	private String roadCityCode; // 도로명시군구코드
	private String roadSerialCode; // 도로명일련번호코드
	private boolean roadIsGround; // 도로명지상지하코드
	private String roadNameCode; // 도로명코드
	private String legalDong; // 법정동
	private String legalMainCode; // 법정동본번코드
	private String legalSubCode; // 법정동부번코드
	private String legalCityCode; // 법정동시군구코드
	private String legalVillageCode; // 법정동읍면동코드
	private String legalZipCode; // 법정동지번코드
	private String aptName; // 아파트
	private int trnscMonth; // 월
	private int trnscDay; // 일
	private String trnscSerialNumber; // 일련번호
	private float aptSize; // 전용면적
	private String aptZip; // 지번
	private String aptRegionCode; // 지역코드
	private int aptFloor; // 층

	public int getTrnscCost() {
		return trnscCost;
	}

	public void setTrnscCost(int trnscCost) {
		this.trnscCost = trnscCost;
	}

	public int getCnstrYear() {
		return cnstrYear;
	}

	public void setCnstrYear(int cnstrYear) {
		this.cnstrYear = cnstrYear;
	}

	public int getTrnscYear() {
		return trnscYear;
	}

	public void setTrnscYear(int trnscYear) {
		this.trnscYear = trnscYear;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getRoadMainCode() {
		return roadMainCode;
	}

	public void setRoadMainCode(String roadMainCode) {
		this.roadMainCode = roadMainCode;
	}

	public String getRoadSubCode() {
		return roadSubCode;
	}

	public void setRoadSubCode(String roadSubCode) {
		this.roadSubCode = roadSubCode;
	}

	public String getRoadCityCode() {
		return roadCityCode;
	}

	public void setRoadCityCode(String roadCityCode) {
		this.roadCityCode = roadCityCode;
	}

	public String getRoadSerialCode() {
		return roadSerialCode;
	}

	public void setRoadSerialCode(String roadSerialCode) {
		this.roadSerialCode = roadSerialCode;
	}

	public boolean isRoadIsGround() {
		return roadIsGround;
	}

	public void setRoadIsGround(boolean roadIsGround) {
		this.roadIsGround = roadIsGround;
	}

	public String getRoadNameCode() {
		return roadNameCode;
	}

	public void setRoadNameCode(String roadNameCode) {
		this.roadNameCode = roadNameCode;
	}

	public String getLegalDong() {
		return legalDong;
	}

	public void setLegalDong(String legalDong) {
		this.legalDong = legalDong;
	}

	public String getLegalMainCode() {
		return legalMainCode;
	}

	public void setLegalMainCode(String legalMainCode) {
		this.legalMainCode = legalMainCode;
	}

	public String getLegalSubCode() {
		return legalSubCode;
	}

	public void setLegalSubCode(String legalSubCode) {
		this.legalSubCode = legalSubCode;
	}

	public String getLegalCityCode() {
		return legalCityCode;
	}

	public void setLegalCityCode(String legalCityCode) {
		this.legalCityCode = legalCityCode;
	}

	public String getLegalVillageCode() {
		return legalVillageCode;
	}

	public void setLegalVillageCode(String legalVillageCode) {
		this.legalVillageCode = legalVillageCode;
	}

	public String getLegalZipCode() {
		return legalZipCode;
	}

	public void setLegalZipCode(String legalZipCode) {
		this.legalZipCode = legalZipCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public int getTrnscMonth() {
		return trnscMonth;
	}

	public void setTrnscMonth(int trnscMonth) {
		this.trnscMonth = trnscMonth;
	}

	public int getTrnscDay() {
		return trnscDay;
	}

	public void setTrnscDay(int trnscDay) {
		this.trnscDay = trnscDay;
	}

	public String getTrnscSerialNumber() {
		return trnscSerialNumber;
	}

	public void setTrnscSerialNumber(String trnscSerialNumber) {
		this.trnscSerialNumber = trnscSerialNumber;
	}

	public float getAptSize() {
		return aptSize;
	}

	public void setAptSize(float aptSize) {
		this.aptSize = aptSize;
	}

	public String getAptZip() {
		return aptZip;
	}

	public void setAptZip(String aptZip) {
		this.aptZip = aptZip;
	}

	public String getAptRegionCode() {
		return aptRegionCode;
	}

	public void setAptRegionCode(String aptRegionCode) {
		this.aptRegionCode = aptRegionCode;
	}

	public int getAptFloor() {
		return aptFloor;
	}

	public void setAptFloor(int aptFloor) {
		this.aptFloor = aptFloor;
	}

	@Override
	public String toString() {
		return "testDto [trnscCost=" + trnscCost + ", cnstrYear=" + cnstrYear + ", trnscYear=" + trnscYear
				+ ", roadName=" + roadName + ", roadMainCode=" + roadMainCode + ", roadSubCode=" + roadSubCode
				+ ", roadCityCode=" + roadCityCode + ", roadSerialCode=" + roadSerialCode + ", roadIsGround="
				+ roadIsGround + ", roadNameCode=" + roadNameCode + ", legalDong=" + legalDong + ", legalMainCode="
				+ legalMainCode + ", legalSubCode=" + legalSubCode + ", legalCityCode=" + legalCityCode
				+ ", legalVillageCode=" + legalVillageCode + ", legalZipCode=" + legalZipCode + ", aptName=" + aptName
				+ ", trnscMonth=" + trnscMonth + ", trnscDay=" + trnscDay + ", trnscSerialNumber=" + trnscSerialNumber
				+ ", aptSize=" + aptSize + ", aptZip=" + aptZip + ", aptRegionCode=" + aptRegionCode + ", aptFloor="
				+ aptFloor + "]";
	}

}
