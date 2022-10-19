package com.ssafy.jdbctest;

import java.io.*;
import java.util.List;

public class ProductMain {
	
	BufferedReader in;

	public ProductMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new ProductMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 등록");
			System.out.println("2. 가격 변경");
			System.out.println("3. 제품삭제");
			System.out.println("4. 아이디로 검색");
			System.out.println("5. 가격으로 검색(이상)");
			System.out.println("6. 모든 상품 출력");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : register();break;
				case 2 : updatePrice();break;
				case 3 : deleteProduct();break;
				case 4 : searchById();break;
				case 5 : searchByPrice();break;
				case 6 : searchAll();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	private void register() {
//		System.out.println("register");
//		유효성 검사는 생략할게요!!!
		try {
			System.out.println("--------------------- 상품 등록 ---------------------");
			System.out.print("상품 아이디 : ");
			String productId = in.readLine();
			System.out.print("상품 이름 : ");
			String productName = in.readLine();
			System.out.print("상품 가격 : ");
			int productPrice = Integer.parseInt(in.readLine());
			System.out.print("상품 설명 : ");
			String productDesc = in.readLine();
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(productId);
			productDto.setProductName(productName);
			productDto.setProductPrice(productPrice);
			productDto.setProductDesc(productDesc);
			
			ProductDao productDao = ProductDaoImpl.getProductDao();
			productDao.register(productDto);
			System.out.println("-------------------------------------------------");
			System.out.println("상품 등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updatePrice() {
//		System.out.println("updatePrice");
		try {
			System.out.println("--------------------- 상품 가격 변경 ---------------------");
			System.out.print("변경할 상품 아이디 : ");
			String productId = in.readLine();
			System.out.print("변경할 상품 가격 : ");
			int productPrice = Integer.parseInt(in.readLine());
			
			ProductDaoImpl.getProductDao().updatePrice(productId, productPrice);
			System.out.println("-------------------------------------------------");
			System.out.println("상품 가격 변경 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteProduct() {
//		System.out.println("deleteProduct");
		try {
			System.out.println("--------------------- 상품 삭제 ---------------------");
			System.out.print("삭제할 상품 아이디 : ");
			String productId = in.readLine();
			
			ProductDaoImpl.getProductDao().deleteProduct(productId);
			System.out.println("-------------------------------------------------");
			System.out.println("상품 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchById() {
//		System.out.println("searchById");
		try {
			System.out.print("변경할 상품 아이디 : ");
			String productId = in.readLine();
			ProductDto productDto = ProductDaoImpl.getProductDao().searchById(productId);
			showProduct(productDto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchByPrice() {
//		System.out.println("searchByPrice");
		try {
			System.out.print("검색할 상품 가격(최저가) : ");
			int productPrice = Integer.parseInt(in.readLine());
			List<ProductDto> list = ProductDaoImpl.getProductDao().searchByPrice(productPrice);
			showList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchAll() {
//		System.out.println("searchAll");
		List<ProductDto> list = ProductDaoImpl.getProductDao().searchAll();
		showList(list);
	}

	private void showProduct(ProductDto productDto) {
		if(productDto != null) {
			System.out.println("============ 상품 정보 ============");
			System.out.println("상품 아이디 : " + productDto.getProductId());
			System.out.println("상품 이름 : " + productDto.getProductName());
			System.out.println("상품 가격 : " + productDto.getProductPrice() + "원");
			System.out.println("상품 설명 : " + productDto.getProductDesc());
			System.out.println("상품 등록일 : " + productDto.getRegisterDate());
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("상품이 존재하지 않습니다.");
			System.out.println("-------------------------------------------------");
		}
	}
	
	private void showList(List<ProductDto> list) {
		System.out.println("===================================== 상품 목록 =====================================");
		System.out.println("상품아이디\t상품이름\t상품가격\t등록일\t\t상품설명");
		System.out.println("-------------------------------------------------------------------------------------");
		for(ProductDto productDto : list) {
			System.out.println(productDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
