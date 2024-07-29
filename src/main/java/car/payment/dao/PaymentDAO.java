package car.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.payment.dto.PaymentDTO;
import car.payment.service.PaymentService;

public class PaymentDAO implements PaymentService{
	private static Log log = LogFactory.getLog(PaymentDAO.class);
	@Override
	public ArrayList<PaymentDTO> paymentSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<PaymentDTO> arrayList = new ArrayList<PaymentDTO>( );
		try {
		Context context = new InitialContext( );
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
		connection = dataSource.getConnection( );
		String sql = "select payment_code, payment_card_num, payment_card_company, payment_total, payment_date from payment ";
		log.info("SQL 확인 - " + sql);																							
		preparedStatement = connection.prepareStatement(sql);
		
		// SQL인 select…from…where 문을 실행하고 데이터를 조회한다.
		resultSet = preparedStatement.executeQuery( );
		while(resultSet.next( )) {
			PaymentDTO paymentDTO = new PaymentDTO( );
			paymentDTO.setPayment_code(resultSet.getInt("payment_code"));
			paymentDTO.setPayment_card_num(resultSet.getString("payment_card_num"));
			paymentDTO.setPayment_card_company(resultSet.getString("payment_card_company"));
			paymentDTO.setPayment_total(resultSet.getInt("payment_total"));
			paymentDTO.setPayment_date(resultSet.getDate("payment_date"));
		
		// 저장한 정보를 DeptDTO 클래스의 인스턴스에 추가한다.
		arrayList.add(paymentDTO);
		}
		
		// 현재 행 번호를 검색한다.
		resultSet.getRow( );
		if(resultSet.getRow( ) == 0) {
			log.info("등록한 결제정보가 없습니다. 결제정보를 입력해주세요.");
		}
		} catch(Exception e) {
			log.info("결제 코드번호 조회 실패 - " + e);
		} finally {
			try {
			resultSet.close( );
			preparedStatement.close( );
			connection.close( );
		} catch(SQLException e) {
			e.printStackTrace( );
			}
		  } return arrayList;
		}

	@Override
	public PaymentDTO paymentSelect(int payment_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		PaymentDTO paymentDTO = new PaymentDTO();
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select payment_code, payment_card_num, payment_card_company, payment_total, payment_date from payment ";
			sql += " where payment_code = ? ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, payment_code);
			
			resultSet = preparedStatement.executeQuery( );
			
			while (resultSet.next()) {
				
				paymentDTO.setPayment_code(resultSet.getInt("payment_code"));
				paymentDTO.setPayment_card_num(resultSet.getString("payment_card_num"));
				paymentDTO.setPayment_card_company(resultSet.getString("payment_card_company"));
				paymentDTO.setPayment_total(resultSet.getInt("payment_total"));
				paymentDTO.setPayment_date(resultSet.getDate("payment_date"));
			}
		} catch (Exception e) {
			log.info("특정 결제 코드번호 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return paymentDTO;
	}

	@Override
	public PaymentDTO paymentInsert(PaymentDTO paymentDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "insert into payment (payment_code, payment_card_num, payment_card_company, payment_total, payment_date ) ";
			sql += "values ( payment_code_seq.NEXTVAL , ? , ? , ? , SYSDATE) ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paymentDTO.getPayment_card_num());
			preparedStatement.setString(2, paymentDTO.getPayment_card_company());
			preparedStatement.setInt(3, paymentDTO.getPayment_total());
			
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("결제 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return paymentDTO;
	}

	@Override
	public PaymentDTO paymentUpdate(PaymentDTO paymentDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			
			String sql = "UPDATE payment SET payment_code = ?, payment_card_num = ?, payment_card_company = ?, payment_total = ? ";
			sql += "WHERE payment_code = ?";

			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,  paymentDTO.getPayment_code());
			preparedStatement.setString(2,  paymentDTO.getPayment_card_num());
			preparedStatement.setString(3,  paymentDTO.getPayment_card_company());
			preparedStatement.setInt(4,  paymentDTO.getPayment_total());
			preparedStatement.setInt(5, paymentDTO.getPayment_code()); 
			
			int count = preparedStatement.executeUpdate();
			if(count > 0) { connection.commit( );
			log.info("커밋되었습니다.");
			} else { connection.rollback( );
			log.info("롤백되었습니다.");
			}			
		} catch (Exception e) {
			log.info("결제 코드 번호 수정 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return paymentDTO;
	}

	@Override
	public PaymentDTO paymentDelete(int payment_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "delete from payment ";
			sql += " where payment_code = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, payment_code);
			
			int count = preparedStatement.executeUpdate( );
			if(count > 0) {
				connection.commit( );
				log.info("커밋되었습니다.");
			} else {
				connection.rollback( );
				log.info("롤백되었습니다.");
				}
			} catch(Exception e) {
				log.info("결제 정보 삭제 실패 - " + e);
			} finally {				
				try {
					preparedStatement.close( );
					connection.close( );
			} catch(SQLException e)
				{
				e.printStackTrace( );
			}
		} return null;
	}
}