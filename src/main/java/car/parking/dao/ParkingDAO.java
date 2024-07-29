package car.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.parking.dto.ParkingDTO;
import car.parking.service.ParkingService;

public class ParkingDAO implements ParkingService {
	
	private static final Log log = LogFactory.getLog(ParkingDAO.class);

	@Override
	public ArrayList<ParkingDTO> parkingSelectAll(int member_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ParkingDTO> arrayList = new ArrayList<ParkingDTO>();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select parking_code, parking_name, parking_approval from parking ";
			sql += "where member_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				ParkingDTO parkingDTO = new ParkingDTO();
				parkingDTO.setParking_code(resultSet.getInt("parking_code"));
				parkingDTO.setParking_name(resultSet.getString("parking_name"));
				parkingDTO.setParking_approval(resultSet.getString("parking_approval"));
				arrayList.add(parkingDTO);
			}
			
			if (resultSet.getRow() == 0) {
				log.info(member_code + " 회원님의 계정으로 등록된 주차장이 없습니다. 주차장을 등록해주세요.");
			}
			
		} catch (NamingException e) {
			log.info(member_code + "회원 주차장 전체 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(member_code + "회원 주차장 전체 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				log.info("주차장 전체 조회 close 실패 - " + e);
				e.printStackTrace();
			}
		}
		
		return arrayList;
	}
	
	@Override
	public ArrayList<ParkingDTO> parkingSelectAdmin() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ParkingDTO> arrayList = new ArrayList<ParkingDTO>();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select parking_code, parking_name, parking_approval from parking ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				ParkingDTO parkingDTO = new ParkingDTO();
				parkingDTO.setParking_code(resultSet.getInt("parking_code"));
				parkingDTO.setParking_name(resultSet.getString("parking_name"));
				parkingDTO.setParking_approval(resultSet.getString("parking_approval"));
				arrayList.add(parkingDTO);
			}
			
			if (resultSet.getRow() == 0) {
				log.info("등록된 주차장이 없습니다.");
			}
			
		} catch (NamingException e) {
			log.info("admin 주차장 전체 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info("admin 주차장 전체 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				log.info("admin 주차장 전체 조회 close 실패 - " + e);
				e.printStackTrace();
			}
		}
		
		return arrayList;
	}

	@Override
	public ParkingDTO parkingSelectDetail(int parking_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ParkingDTO parkingDTO = new ParkingDTO();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select parking_name, parking_address, parking_latitude, parking_longitude, parking_operation, "
					+ "parking_type, parking_total_spaces, parking_electriccar_check, parking_electriccar_spaces, "
					+ "parking_pay_type, parking_base_fee, parking_hourly_rate, parking_approval, "
					+ "to_char(parking_registration, 'YYYY\"년\" MM\"월\" DD\"일\"') parking_registration, to_char(parking_edit, 'YYYY\"년\" MM\"월\" DD\"일\"') parking_edit from parking ";
			sql += "where parking_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, parking_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				parkingDTO.setParking_code(parking_code);
				parkingDTO.setParking_name(resultSet.getString("parking_name"));
				parkingDTO.setParking_address(resultSet.getString("parking_address"));
				parkingDTO.setParking_operation(resultSet.getString("parking_operation"));
				parkingDTO.setParking_latitude(resultSet.getDouble("parking_latitude"));
				log.info("parking_latitude - " + parkingDTO.getParking_latitude());
				parkingDTO.setParking_longitude(resultSet.getDouble("parking_longitude"));
				log.info("parking_longitude - " + parkingDTO.getParking_longitude());
				parkingDTO.setParking_type(resultSet.getString("parking_type"));
				parkingDTO.setParking_total_spaces(resultSet.getString("parking_total_spaces"));
				parkingDTO.setParking_electriccar_check(resultSet.getString("parking_electriccar_check"));
				parkingDTO.setParking_electriccar_spaces(resultSet.getString("parking_electriccar_spaces"));
				parkingDTO.setParking_pay_type(resultSet.getString("parking_pay_type"));
				parkingDTO.setParking_base_fee(resultSet.getString("parking_base_fee"));
				parkingDTO.setParking_hourly_rate(resultSet.getString("parking_hourly_rate"));
				parkingDTO.setParking_approval(resultSet.getString("parking_approval"));
				parkingDTO.setParking_registration(resultSet.getString("parking_registration"));
				parkingDTO.setParking_edit(resultSet.getString("parking_edit"));
				
			}
			
		} catch (NamingException e) {
			log.info(parking_code + " 주차장 상세 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parking_code + " 주차장 상세 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return parkingDTO;
	}

	@Override
	public void parkingInsert(ParkingDTO parkingDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "insert into parking (parking_code, parking_name, parking_address, parking_latitude, parking_longitude, parking_operation, "
					+ "parking_type, parking_total_spaces, parking_electriccar_check, parking_electriccar_spaces, "
					+ "parking_pay_type, parking_base_fee, parking_hourly_rate, "
					+ "parking_photo1_name, parking_photo1_path, parking_photo2_name, parking_photo2_path, "
					+ "parking_photo3_name, parking_photo3_path, parking_photo4_name, parking_photo4_path, "
					+ "parking_photo5_name, parking_photo5_path, parking_document_name, parking_document_path, "
					+ "parking_registration, parking_edit, member_code)";
			sql += " values (parking_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate, ?)";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, parkingDTO.getParking_name());
			preparedStatement.setString(2, parkingDTO.getParking_address());
			preparedStatement.setDouble(3, parkingDTO.getParking_latitude());
			preparedStatement.setDouble(4, parkingDTO.getParking_longitude());
			preparedStatement.setString(5, parkingDTO.getParking_operation());
			preparedStatement.setString(6, parkingDTO.getParking_type());
			preparedStatement.setString(7, parkingDTO.getParking_total_spaces());
			preparedStatement.setString(8, parkingDTO.getParking_electriccar_check());
			preparedStatement.setString(9, parkingDTO.getParking_electriccar_spaces());
			preparedStatement.setString(10, parkingDTO.getParking_pay_type());
			preparedStatement.setString(11, parkingDTO.getParking_base_fee());
			preparedStatement.setString(12, parkingDTO.getParking_hourly_rate());
			preparedStatement.setString(13, parkingDTO.getParking_photo1_name());
			preparedStatement.setString(14, parkingDTO.getParking_photo1_path());
			preparedStatement.setString(15, parkingDTO.getParking_photo2_name());
			preparedStatement.setString(16, parkingDTO.getParking_photo2_path());
			preparedStatement.setString(17, parkingDTO.getParking_photo3_name());
			preparedStatement.setString(18, parkingDTO.getParking_photo3_path());
			preparedStatement.setString(19, parkingDTO.getParking_photo4_name());
			preparedStatement.setString(20, parkingDTO.getParking_photo4_path());
			preparedStatement.setString(21, parkingDTO.getParking_photo5_name());
			preparedStatement.setString(22, parkingDTO.getParking_photo5_path());
			preparedStatement.setString(23, parkingDTO.getParking_document_name());
			preparedStatement.setString(24, parkingDTO.getParking_document_path());
			preparedStatement.setInt(25, parkingDTO.getMember_code());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("주차장 등록 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 등록 - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info(parkingDTO.getMember_code() + "회원 주차장 등록 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parkingDTO.getMember_code() + "회원 주차장 등록 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void parkingUpdate(ParkingDTO parkingDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "update parking set parking_name = ?, parking_address = ?, parking_latitude = ?, parking_longitude = ?, parking_operation = ?, "
					+ "parking_type = ?, parking_total_spaces = ?, parking_electriccar_check = ?, parking_electriccar_spaces = ?, "
					+ "parking_pay_type = ?, parking_base_fee = ?, parking_hourly_rate = ?, parking_edit = sysdate ";
			sql += "where parking_code = ?";
			log.info(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, parkingDTO.getParking_name());
			preparedStatement.setString(2, parkingDTO.getParking_address());
			preparedStatement.setDouble(3, parkingDTO.getParking_latitude());
			preparedStatement.setDouble(4, parkingDTO.getParking_longitude());
			preparedStatement.setString(5, parkingDTO.getParking_operation());
			preparedStatement.setString(6, parkingDTO.getParking_type());
			preparedStatement.setString(7, parkingDTO.getParking_total_spaces());
			preparedStatement.setString(8, parkingDTO.getParking_electriccar_check());
			preparedStatement.setString(9, parkingDTO.getParking_electriccar_spaces());
			preparedStatement.setString(10, parkingDTO.getParking_pay_type());
			preparedStatement.setString(11, parkingDTO.getParking_base_fee());
			preparedStatement.setString(12, parkingDTO.getParking_hourly_rate());
			preparedStatement.setInt(13, parkingDTO.getParking_code());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("주차장 수정 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 수정 - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info(parkingDTO.getParking_code() + " 주차장 수정 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parkingDTO.getParking_code() + " 주차장 수정 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void parkingDelete(int parking_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			connection.setAutoCommit(false);
			
			String sql1 = "ALTER TABLE calculate DISABLE CONSTRAINT calculate_parking_pk ";
			preparedStatement = connection.prepareStatement(sql1);
			int count1 = preparedStatement.executeUpdate();
			log.info("SQL 확인 - " + sql1);
			
			if (count1 > 0) {
				connection.commit();
				log.info("주차장 정보 삭제(제약조건 비활성화) - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 정보 삭제(제약조건 비활성화) - 롤백되었습니다.");
			}
			
			String sql2 = "DELETE FROM parking WHERE parking_code = ? ";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, parking_code);
			int count2 = preparedStatement.executeUpdate();
			log.info("SQL 확인 - " + sql2);
			
			if (count2 > 0) {
				connection.commit();
				log.info("주차장 정보 삭제 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 정보 삭제 - 롤백되었습니다.");
			}
			
			String sql3 = "ALTER TABLE calculate ENABLE CONSTRAINT calculate_parking_pk ";
			preparedStatement = connection.prepareStatement(sql3);
			int count3 = preparedStatement.executeUpdate();
			log.info("SQL 확인 - " + sql3);
			
			if (count3 > 0) {	
				connection.commit();
				log.info("주차장 정보 삭제(제약조건 활성화) - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 정보 삭제(제약조건 활성화) - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info(parking_code + " 주차장 삭제 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parking_code + " 주차장 삭제 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void parkingApprove(ParkingDTO parkingDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "update parking set parking_approval = ?, parking_edit = sysdate ";
			sql += "where parking_code = ?";
			log.info(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, parkingDTO.getParking_approval());
			preparedStatement.setInt(2, parkingDTO.getParking_code());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("주차장 승인 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차장 승인 - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info(parkingDTO.getParking_code() + " 주차장 승인 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parkingDTO.getParking_code() + " 주차장 승인 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
