package com.ssafy.jdbctest;

import java.util.List;

public interface ProductDao {

	void register(ProductDto productDto);
	ProductDto searchById(String productId);
	List<ProductDto> searchByPrice(int productPrice);
	List<ProductDto> searchAll();
	void updatePrice(String productId, int productPrice);
	void deleteProduct(String productId);
	
}
