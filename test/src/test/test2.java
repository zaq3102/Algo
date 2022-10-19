package test;

import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class test2 {
	Scanner sc;

	public test2() {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new test2().menu();

	} // main end

	private void menu() {
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 등록");
			System.out.println("2. 일련번호로 조회");
			System.out.println("3. 전체 조회");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				register();
				break;
			case 2: // 일련번호로 검색
				searchById();
				break;
			case 3: // 일련번호로 검색
				searchAll();
				break;

			default:
				isContinue = false;
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	// 1번
	public void register() {

		System.out.println("지역코드 입력 : ");
		int areaCode = sc.nextInt();
		System.out.println("년월입력 입력 : ");
		int dateInfo = sc.nextInt();

		int page = 1; // 페이지 초기값
		try {
			while (true) {
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"
						+ "?serviceKey=PF%2B0hgKn4ATf1rSc%2BAGMQ7y1PJn87AtT1Ys0rXWcy%2Beu5kw2ADl6KdICavpvAEMrAaVo%2BBkbt8d33p%2FaLA1vfQ%3D%3D"
						+ "&pageNo=" + page + "&numOfRows=10" + "&LAWD_CD=" + areaCode + "&DEAL_YMD=" + dateInfo;

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);

				// root tag
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						System.out.println("######################");

						int trnscCost = Integer.parseInt(getTagValue("거래금액", eElement).trim().replace(",", "")); // 거래금액
						int cnstrYear = Integer.parseInt(getTagValue("년", eElement).trim()); // 년
						int trnscYear = Integer.parseInt(getTagValue("건축년도", eElement).trim()); // 거래년도
						String roadName = getTagValue("도로명", eElement).trim(); // 도로명
						String roadMainCode = getTagValue("도로명건물본번호코드", eElement).trim(); // 도로명건물본번호코드
						String roadSubCode = getTagValue("도로명건물부번호코드", eElement).trim(); // 도로명건물부번호코드
						String roadCityCode = getTagValue("도로명시군구코드", eElement).trim(); // 도로명시군구코드
						String roadSerialCode = getTagValue("도로명일련번호코드", eElement).trim(); // 도로명일련번호코드
						boolean roadIsGround = getTagValue("도로명지상지하코드", eElement).trim() == "1" ? true : false; // 도로명지상지하코드
						String roadNameCode = getTagValue("도로명코드", eElement).trim(); // 도로명코드
						String legalDong = getTagValue("법정동", eElement).trim(); // 법정동
						String legalMainCode = getTagValue("법정동본번코드", eElement).trim(); // 법정동본번코드
						String legalSubCode = getTagValue("법정동부번코드", eElement).trim(); // 법정동부번코드
						String legalCityCode = getTagValue("법정동시군구코드", eElement).trim(); // 법정동시군구코드
						String legalVillageCode = getTagValue("법정동읍면동코드", eElement).trim(); // 법정동읍면동코드
						String legalZipCode = getTagValue("법정동지번코드", eElement).trim(); // 법정동지번코드
						String aptName = getTagValue("아파트", eElement).trim(); // 아파트
						int trnscMonth = Integer.parseInt(getTagValue("월", eElement).trim()); // 월
						int trnscDay = Integer.parseInt(getTagValue("일", eElement).trim()); // 일
						String trnscSerialNumber = getTagValue("일련번호", eElement).trim(); // 일련번호
						float aptSize = Float.parseFloat(getTagValue("전용면적", eElement).trim()); // 전용면적
						String aptZip = getTagValue("지번", eElement).trim(); // 지번
						String aptRegionCode = getTagValue("지역코드", eElement).trim(); // 지역코드
						int aptFloor = Integer.parseInt(getTagValue("층", eElement).trim()); // 층

						// DTO에 담아보자

						testDto testDto = new testDto();
						testDto.setTrnscCost(trnscCost);
						testDto.setCnstrYear(cnstrYear);
						testDto.setTrnscYear(trnscYear);
						testDto.setRoadName(roadName);
						testDto.setRoadMainCode(roadMainCode);
						testDto.setRoadSubCode(roadSubCode);
						testDto.setRoadCityCode(roadCityCode);
						testDto.setRoadSerialCode(roadSerialCode);
						testDto.setRoadIsGround(roadIsGround);
						testDto.setRoadNameCode(roadNameCode);
						testDto.setLegalDong(legalDong);
						testDto.setLegalMainCode(legalMainCode);
						testDto.setLegalSubCode(legalSubCode);
						testDto.setLegalCityCode(legalCityCode);
						testDto.setLegalVillageCode(legalVillageCode);
						testDto.setLegalZipCode(legalZipCode);
						testDto.setAptName(aptName);
						testDto.setTrnscMonth(trnscMonth);
						testDto.setTrnscDay(trnscDay);
						testDto.setTrnscSerialNumber(trnscSerialNumber);
						testDto.setAptSize(aptSize);
						testDto.setAptZip(aptZip);
						testDto.setAptRegionCode(aptRegionCode);
						testDto.setAptFloor(aptFloor);

						System.out.println(testDto.toString());

						testDao testDao = testDaoImpl.gettestDao();
						testDao.register(testDto);
						System.out.println("-------------------------------------------------");
						System.out.println("상품 등록 성공!!!!!" + aptName);
						System.out.println("-------------------------------------------------");

						// DTO 끝

					} // for end
				} // if end

				page += 1;
				System.out.println("page number : " + page);
				if (page > 8) {
					break;
				}
			} // while end

		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
	}

	// 2번 : 일련번호로 조회
	private void searchById() {
		System.out.print("조회할 일련번호 입력 : ");
		String trnscSerialNumber = sc.nextLine();
		testDto testDto = testDaoImpl.gettestDao().searchById(trnscSerialNumber);
		showResult(testDto);
	}

	// 3번 : 전체 조회
	private void searchAll() {
//		System.out.println("searchAll");
		List<testDto> list = testDaoImpl.gettestDao().searchAll();
		showList(list);
	}

	private void showResult(testDto testDto) {
		if (testDto != null) {
			System.out.println("============ 상품 정보 ============");
			System.out.println("일련 번호 : " + testDto.getTrnscSerialNumber());
			System.out.println("법정동 : " + testDto.getLegalDong());
			System.out.println("아파트 이름 : " + testDto.getAptName());
			System.out.println("가격 : " + testDto.getTrnscCost() + "원");
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("결과 없음.");
			System.out.println("-------------------------------------------------");
		}
	}

	private void showList(List<testDto> list) {
		System.out.println("===================================== 전체 조회 =====================================");
		for (testDto testDto : list) {
			System.out.println(testDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}

} // class end