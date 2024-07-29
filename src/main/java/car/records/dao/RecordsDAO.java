package car.records.dao;

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

import car.records.dto.RecordsDTO;
import car.records.service.RecordsService;

public class RecordsDAO implements RecordsService {
	
	private static final Log log = LogFactory.getLog(RecordsDAO.class);
	
	@Override
	public ArrayList<RecordsDTO> recordsSelectUser(int member_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<RecordsDTO> arrayList = new ArrayList<RecordsDTO>();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select records_code, member_car_num, records_start, records_end from records ";
			sql += "where member_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				RecordsDTO recordsDTO = new RecordsDTO();
				recordsDTO.setRecords_code(resultSet.getInt("records_code"));
				recordsDTO.setMember_car_num(resultSet.getString("member_car_num"));
				recordsDTO.setRecords_start(resultSet.getString("records_start"));
				recordsDTO.setRecords_end(resultSet.getString("records_end"));
				arrayList.add(recordsDTO);
				
			}
			
			if (resultSet.getRow() == 0) {
				log.info(member_code + " 회원님의 계정으로 저장된 주차 기록이 없습니다.");
			}
			
		} catch (NamingException e) {
			log.info(member_code + "회원 주차기록 전체 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(member_code + "회원 주차기록 전체 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return arrayList;
	}
	
	@Override
	public ArrayList<RecordsDTO> recordsSelectParkingCode(int member_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<RecordsDTO> arrayList = new ArrayList<RecordsDTO>();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select parking_code, parking_name from parking ";
			sql += "where member_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, member_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				RecordsDTO recordsDTO = new RecordsDTO();
				recordsDTO.setParking_code(resultSet.getInt("parking_code"));
				recordsDTO.setParking_name(resultSet.getString("parking_name"));
				recordsDTO.setMember_code(member_code);
				arrayList.add(recordsDTO);
				
			}
			
			if (resultSet.getRow() == 0) {
				log.info(member_code + " 회원님의 계정으로 저장된 주차장이 없습니다.");
			}
			
		} catch (NamingException e) {
			log.info(member_code + "회원 주차기록 전체 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(member_code + "회원 주차기록 전체 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return arrayList;
		
	}
	
	@Override
	public ArrayList<RecordsDTO> recordsSelectParking(int parking_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<RecordsDTO> arrayList = new ArrayList<RecordsDTO>();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select records_code, member_car_num, "
					+ "to_char(records_start, 'YYYY-MM-DD hh24:mi:SS') records_start, to_char(records_end, 'YYYY-MM-DD hh24:mi:SS') records_end from records ";
			sql += "where parking_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, parking_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				RecordsDTO recordsDTO = new RecordsDTO();
				recordsDTO.setParking_code(parking_code);
				recordsDTO.setRecords_code(resultSet.getInt("records_code"));
				recordsDTO.setMember_car_num(resultSet.getString("member_car_num"));
				recordsDTO.setRecords_start(resultSet.getString("records_start"));
				recordsDTO.setRecords_end(resultSet.getString("records_end"));
				arrayList.add(recordsDTO);
				
			}
			
			if (resultSet.getRow() == 0) {
				log.info(parking_code + " 주차장 번호에 저장된 주차 기록이 없습니다.");
			}
			
		} catch (NamingException e) {
			log.info(parking_code + " 주차장 주차기록 전체 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(parking_code + " 주차장 주차기록 전체 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return arrayList;
		
	}
	
	@Override
	public RecordsDTO recordsSelectDetailUser(int records_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RecordsDTO recordsDTO = new RecordsDTO();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select records_code, member_code, member_car_num, parking_name, "
					+ "to_char(records_start, 'YYYY-MM-DD hh24:mi:SS') records_start, to_char(records_end, 'YYYY-MM-DD hh24:mi:SS') records_end, payment_total from records ";
			sql += "where records_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, records_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				recordsDTO.setRecords_code(resultSet.getInt("records_code"));
				recordsDTO.setMember_code(resultSet.getInt("member_code"));
				recordsDTO.setMember_car_num(resultSet.getString("member_car_num"));
				recordsDTO.setParking_name(resultSet.getString("parking_name"));
				recordsDTO.setRecords_start(resultSet.getString("records_start"));
				recordsDTO.setRecords_end(resultSet.getString("records_end"));
				recordsDTO.setPayment_total(resultSet.getString("payment_total"));
				log.info("recordsDTO - " + recordsDTO);
				
			}
			
		} catch (NamingException e) {
			log.info(records_code + " - 사용자 주차 기록 상세 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(records_code + " - 사용자 주차 기록 상세 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return recordsDTO;
	}
	
	@Override
	public RecordsDTO recordsSelectDetailParking(int records_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RecordsDTO recordsDTO = new RecordsDTO();
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select records_code, member_code, member_car_num, parking_code, parking_name, "
					+ "to_char(records_start, 'YYYY-MM-DD hh24:mi:SS') records_start, to_char(records_end, 'YYYY-MM-DD hh24:mi:SS') records_end, payment_total from records ";
			sql += "where records_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, records_code);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				recordsDTO.setRecords_code(resultSet.getInt("records_code"));
				recordsDTO.setMember_code(resultSet.getInt("member_code"));
				recordsDTO.setMember_car_num(resultSet.getString("member_car_num"));
				recordsDTO.setParking_code(resultSet.getInt("parking_code"));
				recordsDTO.setParking_name(resultSet.getString("parking_name"));
				recordsDTO.setRecords_start(resultSet.getString("records_start"));
				recordsDTO.setRecords_end(resultSet.getString("records_end"));
				recordsDTO.setPayment_total(resultSet.getString("payment_total"));
				log.info("recordsDTO - " + recordsDTO);
				
			}
			
		} catch (NamingException e) {
			log.info(records_code + " - 관리자 주차 기록 상세 조회 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info(records_code + " - 관리자 주차 기록 상세 조회 실패(SQLException) - " + e);
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return recordsDTO;
	}
	
	@Override
	public void recordsInsert(RecordsDTO recordsDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "insert into records (records_code, member_code, member_car_num, parking_code, parking_name, records_start) ";
			sql += "values (records_seq.NEXTVAL, ?, ?, ?, ?, sysdate) ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, recordsDTO.getMember_code());
			preparedStatement.setString(2, recordsDTO.getMember_car_num());
			preparedStatement.setInt(3, recordsDTO.getParking_code());
			preparedStatement.setString(4, recordsDTO.getParking_name());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("주차 기록 등록 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차 기록 등록 - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info("주차 기록 등록 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info("주차 기록 등록 실패(SQLException) - " + e);
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
	public void recordsUpdate(RecordsDTO recordsDTO) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "update records set records_end = sysdate, payment_total = ? ";
			sql += "where records_code = ? ";
			log.info("SQL 확인 - " + sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, recordsDTO.getPayment_total());
			preparedStatement.setInt(2, recordsDTO.getRecords_code());
			
			int count = preparedStatement.executeUpdate();
			
			if (count > 0) {
				connection.setAutoCommit(false);
				connection.commit();
				log.info("주차 기록 수정 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차 기록 수정 - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info("주차 기록 수정 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info("주차 기록 수정 실패(SQLException) - " + e);
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
	public void recordsDelete(int records_code) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			connection.setAutoCommit(false);
			
			String sql1 = "ALTER TABLE calculate DISABLE CONSTRAINT calculate_records_pk ";
			preparedStatement = connection.prepareStatement(sql1);
			int count1 = preparedStatement.executeUpdate();
			
			if (count1 > 0) {
				connection.commit();
				log.info("주차 기록 삭제(제약조건 비활성화) - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차 기록 삭제(제약조건 비활성화) - 롤백되었습니다.");
			}
			
			String sql2 = "DELETE FROM records WHERE records_code = ? ";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, records_code);
			int count2 = preparedStatement.executeUpdate();
			
			if (count2 > 0) {
				connection.commit();
				log.info("주차 기록 삭제 - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차 기록 삭제 - 롤백되었습니다.");
			}
			
			String sql3 = "ALTER TABLE calculate ENABLE CONSTRAINT calculate_records_pk ";
			preparedStatement = connection.prepareStatement(sql3);
			int count3 = preparedStatement.executeUpdate();
			log.info("SQL 확인 - " + sql3);
			
			if (count3 > 0) {	
				connection.commit();
				log.info("주차 기록 삭제(제약조건 활성화) - 커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("주차 기록 삭제(제약조건 활성화) - 롤백되었습니다.");
			}
			
		} catch (NamingException e) {
			log.info("주차 기록 삭제 실패(NamingException) - " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.info("주차 기록 삭제 실패(SQLException) - " + e);
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
