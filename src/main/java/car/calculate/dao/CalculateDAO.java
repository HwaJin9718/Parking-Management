package car.calculate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.calculate.dto.CalculateDTO;
import car.calculate.service.CalculateService;

public class CalculateDAO implements CalculateService{
	private static Log log = LogFactory.getLog(CalculateDAO.class);
	
	@Override
	public ArrayList<CalculateDTO> calculateSearchById(int member_code) {
	    Connection connection = null;
	    PreparedStatement selectPreparedStatement = null;
	    ResultSet resultSet = null;
	    ArrayList<CalculateDTO> arrayList = new ArrayList<CalculateDTO>();

	    try {
	        Context context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = dataSource.getConnection();

	        String selectSql = "SELECT c.calculate_code, c.calculate_date, c.calculate_amount, "
	                + "c.calculate_status, p.parking_base_fee, p.parking_hourly_rate, "
	                + "r.records_start, r.records_end, m.member_code "
	                + "FROM calculate c "
	                + "JOIN parking p ON c.parking_code = p.parking_code "
	                + "JOIN records r ON c.records_code = r.records_code "
	                + "JOIN member m ON c.member_code = m.member_code "
	                + "WHERE c.member_code = ?";


	        log.info("SELECT SQL 확인 - " + selectSql);
	        selectPreparedStatement = connection.prepareStatement(selectSql);
	        selectPreparedStatement.setInt(1, member_code);
	        resultSet = selectPreparedStatement.executeQuery();

	        while (resultSet.next()) {
	            CalculateDTO calculateDTO = new CalculateDTO();
	            calculateDTO.setCalculate_code(resultSet.getInt("calculate_code"));
	            calculateDTO.setCalculate_date(resultSet.getString("calculate_date"));
	            calculateDTO.setCalculate_amount(resultSet.getString("calculate_amount"));
	            calculateDTO.setCalculate_status(resultSet.getString("calculate_status"));
	            calculateDTO.setParking_base_fee(resultSet.getString("parking_base_fee"));
	            calculateDTO.setParking_hourly_rate(resultSet.getString("parking_hourly_rate"));
	            calculateDTO.setRecords_start(resultSet.getString("records_start"));
	            calculateDTO.setRecords_end(resultSet.getString("records_end"));
	            calculateDTO.setMember_code(resultSet.getInt("member_code"));
	            arrayList.add(calculateDTO);
	        }

	        if (arrayList.isEmpty()) {
	            log.info("등록된 정보 없음");
	        }
	    } catch (Exception e) {
	        log.error("예외 발생: " + e.getMessage());
	    } finally {
	        try {
	            if (resultSet != null)
	                resultSet.close();
	            if (selectPreparedStatement != null)
	                selectPreparedStatement.close();
	            if (connection != null)
	                connection.close();
	        } catch (SQLException e) {
	            log.error("DB 자원 해제 중 예외 발생: " + e.getMessage());
	        }
	    }

	    return arrayList;
	}



	@Override
	public void calculateUpdate(ArrayList<CalculateDTO> arrayList) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        Context context = new InitialContext();
	        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = dataSource.getConnection();
	        connection.setAutoCommit(false); // 자동 커밋 비활성화
	        
	        String sql = "UPDATE calculate "
	                + "SET calculate_amount = ?, calculate_date = ?, calculate_status = ? "
	                + "WHERE member_code = ?";

	        log.info("SQL 확인 - " + sql);
	        preparedStatement = connection.prepareStatement(sql);
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        for (CalculateDTO calculateDTO : arrayList) {
	            preparedStatement.setString(1, calculateDTO.getCalculate_amount());
	            Date calculateDate = dateFormat.parse(calculateDTO.getCalculate_date());
	            preparedStatement.setTimestamp(2, new Timestamp(calculateDate.getTime()));
	            if (calculateDTO.getCalculate_amount() != null) {
	                preparedStatement.setString(3, "미정산");
	            } else {
	                preparedStatement.setString(3, calculateDTO.getCalculate_status());
	            }
	            preparedStatement.setInt(4, calculateDTO.getMember_code());
	            preparedStatement.addBatch(); // 배치 처리를 위해 SQL 배치에 추가
	        }
	        
	        int[] counts = preparedStatement.executeBatch(); // 배치로 업데이트 실행
	        connection.commit(); // 커밋
	        
	        log.info("총 " + counts.length + " 개의 행이 업데이트 되었습니다.");
	    } catch (Exception e) {
	        try {
	            if (connection != null) {
	                connection.rollback(); // 롤백
	            }
	        } catch (SQLException ex) {
	            log.error("롤백 중 오류 발생: " + ex.getMessage());
	        }
	        log.error("업데이트 실패: " + e.getMessage());
	    } finally {
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException ex) {
	            log.error("자원 해제 중 오류 발생: " + ex.getMessage());
	        }
	    }
	}

}
