package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.util.DBClose;
import test.util.DBConnection;

public class testDaoImpl implements testDao {

	private static testDao testDao;

	private testDaoImpl() {
	}

	public static testDao gettestDao() {
		if (testDao == null)
			testDao = new testDaoImpl();
		return testDao;
	}

	@Override
	public void register(testDto testDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into info (trnscCost, cnstrYear, trnscYear, roadName, roadMainCode, roadSubCode, roadCityCode, roadSerialCode, roadIsGround, roadNameCode, legalDong, legalMainCode, legalSubCode, legalCityCode, legalVillageCode, legalZipCode, aptName, trnscMonth, trnscDay, trnscSerialNumber, aptSize, aptZip, aptRegionCode, aptFloor) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, testDto.getTrnscCost());
			pstmt.setInt(2, testDto.getCnstrYear());
			pstmt.setInt(3, testDto.getTrnscYear());
			pstmt.setString(4, testDto.getRoadName());
			pstmt.setString(5, testDto.getRoadMainCode());
			pstmt.setString(6, testDto.getRoadSubCode());
			pstmt.setString(7, testDto.getRoadCityCode());
			pstmt.setString(8, testDto.getRoadSerialCode());
			pstmt.setBoolean(9, testDto.isRoadIsGround());
			pstmt.setString(10, testDto.getRoadNameCode());
			pstmt.setString(11, testDto.getLegalDong());
			pstmt.setString(12, testDto.getLegalMainCode());
			pstmt.setString(13, testDto.getLegalSubCode());
			pstmt.setString(14, testDto.getLegalCityCode());
			pstmt.setString(15, testDto.getLegalVillageCode());
			pstmt.setString(16, testDto.getLegalZipCode());
			pstmt.setString(17, testDto.getAptName());
			pstmt.setInt(18, testDto.getTrnscMonth());
			pstmt.setInt(19, testDto.getTrnscDay());
			pstmt.setString(20, testDto.getTrnscSerialNumber());
			pstmt.setFloat(21, testDto.getAptSize());
			pstmt.setString(22, testDto.getAptZip());
			pstmt.setString(23, testDto.getAptRegionCode());
			pstmt.setInt(24, testDto.getAptFloor());

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
	public testDto searchById(String trnscSerialNumber) {
		testDto testDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select trnscSerialNumber, legalDong, aptName, trnscCost ";
			sql += "from info ";
			sql += "where trnscSerialNumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trnscSerialNumber);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				testDto = new testDto();
				testDto.setTrnscSerialNumber(rs.getString("trnscSerialNumber"));
				testDto.setLegalDong(rs.getString("legalDong"));
				testDto.setAptName(rs.getString("aptName"));
				testDto.setTrnscCost(rs.getInt("trnscCost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return testDto;
	}

	@Override
	public List<testDto> searchAll() {
		List<testDto> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();) {

			String sql = "select trnscCost, cnstrYear, trnscYear, roadName, roadMainCode, roadSubCode, roadCityCode, roadSerialCode, roadIsGround, roadNameCode, legalDong, legalMainCode, legalSubCode, "
					+ "legalCityCode, legalVillageCode, legalZipCode, aptName, trnscMonth, trnscDay, trnscSerialNumber, aptSize, aptZip, aptRegionCode, aptFloor ";
			sql += "from info";
			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					testDto testDto = new testDto();
					testDto.setTrnscCost(rs.getInt("trnscCost"));
					testDto.setCnstrYear(rs.getInt("cnstrYear"));
					testDto.setTrnscYear(rs.getInt("trnscYear"));
					testDto.setRoadName(rs.getString("roadName"));
					testDto.setRoadMainCode(rs.getString("roadMainCode"));
					testDto.setRoadSubCode(rs.getString("roadSubCode"));
					testDto.setRoadCityCode(rs.getString("roadCityCode"));
					testDto.setRoadSerialCode(rs.getString("roadSerialCode"));
					testDto.setRoadIsGround(rs.getBoolean("roadIsGround"));
					testDto.setRoadNameCode(rs.getString("roadNameCode"));
					testDto.setLegalDong(rs.getString("legalDong"));
					testDto.setLegalMainCode(rs.getString("legalMainCode"));
					testDto.setLegalSubCode(rs.getString("legalSubCode"));
					testDto.setLegalCityCode(rs.getString("legalCityCode"));
					testDto.setLegalVillageCode(rs.getString("legalVillageCode"));
					testDto.setLegalZipCode(rs.getString("legalZipCode"));
					testDto.setAptName(rs.getString("aptName"));
					testDto.setTrnscMonth(rs.getInt("trnscMonth"));
					testDto.setTrnscDay(rs.getInt("trnscDay"));
					testDto.setTrnscSerialNumber(rs.getString("trnscSerialNumber"));
					testDto.setAptSize(rs.getFloat("aptSize"));
					testDto.setAptZip(rs.getString("aptZip"));
					testDto.setAptRegionCode(rs.getString("aptRegionCode"));
					testDto.setAptFloor(rs.getInt("aptFloor"));

					list.add(testDto);
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
