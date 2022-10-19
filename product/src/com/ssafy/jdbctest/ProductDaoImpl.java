package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.jdbctest.util.DBClose;
import com.ssafy.jdbctest.util.DBConnection;

/*
 * JDBC 작업 순서
 * 1. Driver Loading
 * 2. DB 연결 (Connection 생성)
 * 3. SQL 실행 준비
 *   3-1. SQL 작성.
 *   3-2. Statement 생성 (Statement, PreparedStatement)
 * 4. SQL 실행
 *   4-1. I, U, D
 *      int x = stmt.execteUpdate(sql);
 *   	int x = pstmt.executeUpdate();
 *   4-2. S
 *      ResultSet rs = pstmt.executeQuery();
 *      rs.next() [단독, if, while]
 *      값얻기 : rs.getString()
 *            rs.getInt() 등등등....
 * 5. DB 연결 종료 : 연결 역순으로 종료, finally
 * 	if(rs != null)
 *    	rs.close()
 *  if(pstmt != null)
 *  	pstmt.close();
 *  if(conn != null)
 *  	conn.close();
 */

//DAO : DataBase Access Object
public class ProductDaoImpl implements ProductDao {

	private static ProductDao productDao;

	private ProductDaoImpl() {}

	public static ProductDao getProductDao() {
		if (productDao == null)
			productDao = new ProductDaoImpl();
		return productDao;
	}

	@Override
	public void register(ProductDto productDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into product (product_id, product_name, product_price, product_desc) values (?, ?, ?, ?)";
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDto.getProductId());
			pstmt.setString(2, productDto.getProductName());
			pstmt.setInt(3, productDto.getProductPrice());
			pstmt.setString(4, productDto.getProductDesc());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updatePrice(String productId, int productPrice) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update product ";
			sql += "set product_price = ? ";
			sql += "where product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productPrice);
			pstmt.setString(2, productId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteProduct(String productId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from product where product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ProductDto searchById(String productId) {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select product_id, product_name, product_price, product_desc, ";
			sql += "date_format(register_date, '%y.%m.%d') register_date ";
			sql += "from product ";
			sql += "where product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setProductPrice(rs.getInt("product_price"));
				productDto.setProductDesc(rs.getString("product_desc"));
				productDto.setRegisterDate(rs.getString("register_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return productDto;
	}

	@Override
	public List<ProductDto> searchByPrice(int productPrice) {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select product_id, product_name, product_price, product_desc, ";
			sql += "date_format(register_date, '%y.%m.%d') register_date ";
			sql += "from product ";
			sql += "where product_price >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productPrice);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getString("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setProductPrice(rs.getInt("product_price"));
				productDto.setProductDesc(rs.getString("product_desc"));
				productDto.setRegisterDate(rs.getString("register_date"));

				list.add(productDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ProductDto> searchAll() {
		List<ProductDto> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();) {

			String sql = "select product_id, product_name, product_price, product_desc, ";
			sql += "date_format(register_date, '%y.%m.%d') register_date ";
			sql += "from product";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ProductDto productDto = new ProductDto();
					productDto.setProductId(rs.getString("product_id"));
					productDto.setProductName(rs.getString("product_name"));
					productDto.setProductPrice(rs.getInt("product_price"));
					productDto.setProductDesc(rs.getString("product_desc"));
					productDto.setRegisterDate(rs.getString("register_date"));

					list.add(productDto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
