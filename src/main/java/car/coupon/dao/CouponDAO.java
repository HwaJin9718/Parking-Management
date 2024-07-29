package car.coupon.dao;

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

import car.coupon.dto.CouponDTO;
import car.coupon.service.CouponService;

public class CouponDAO implements CouponService{
	private static Log log = LogFactory.getLog(CouponDAO.class);
	@Override
	public ArrayList<CouponDTO> couponSelectAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<CouponDTO> arrayList = new ArrayList<CouponDTO>();
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select coupon_code, coupon_type, coupon_name, coupon_start, coupon_end, coupon_price, coupon_use from coupon ";
			log.info("SQL 확인 - " + sql);																							
			preparedStatement = connection.prepareStatement(sql);
			
			// SQL인 select…from…where 문을 실행하고 데이터를 조회한다.
			resultSet = preparedStatement.executeQuery( );
			while (resultSet.next()) {
				CouponDTO couponDTO = new CouponDTO();
				couponDTO.setCoupon_code(resultSet.getInt("coupon_code"));
				couponDTO.setCoupon_type(resultSet.getString("coupon_type"));
				couponDTO.setCoupon_name(resultSet.getString("coupon_name"));
				couponDTO.setCoupon_start(resultSet.getDate("coupon_start"));
				couponDTO.setCoupon_end(resultSet.getDate("coupon_end"));
				couponDTO.setCoupon_price(resultSet.getInt("coupon_price"));
				couponDTO.setCoupon_use(resultSet.getString("coupon_use"));
				
			arrayList.add(couponDTO);				
			}
			
			resultSet.getRow( );
			if(resultSet.getRow( ) == 0) {
				log.info("등록한 쿠폰정보가 없습니다. 쿠폰정보를 입력해주세요.");
			}
			} catch(Exception e) {
				log.info(" 쿠폰 코드 번호 조회 실패 - " + e);
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
	public CouponDTO couponSelect(int coupon_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CouponDTO couponDTO = new CouponDTO();
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "SELECT coupon_code, coupon_type, coupon_name, coupon_start, coupon_end, coupon_price, coupon_use FROM coupon ";
	        sql += "WHERE coupon_code = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, coupon_code);
			
			resultSet = preparedStatement.executeQuery( );
			
			
			while (resultSet.next()) {
				
				couponDTO.setCoupon_code(resultSet.getInt("coupon_code"));
				couponDTO.setCoupon_type(resultSet.getString("coupon_type"));
				couponDTO.setCoupon_name(resultSet.getString("coupon_name"));
				couponDTO.setCoupon_start(resultSet.getDate("coupon_start"));
				couponDTO.setCoupon_end(resultSet.getDate("coupon_end"));
				couponDTO.setCoupon_price(resultSet.getInt("coupon_price"));
				couponDTO.setCoupon_use(resultSet.getString("coupon_use"));
				
			}
		} catch (Exception e) {
			log.info("특정 쿠폰 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close( );
				preparedStatement.close( );
				connection.close( );				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return couponDTO;
	}

	@Override
	public CouponDTO couponInsert(CouponDTO couponDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "insert into coupon (coupon_code, coupon_type, coupon_name, coupon_price, coupon_start, coupon_end, coupon_use ) ";
			sql += " values ( coupon_seq.NEXTVAL , ? , ? , ? , sysdate , sysdate+30, ? ) ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,  couponDTO.getCoupon_type());
			preparedStatement.setString(2,  couponDTO.getCoupon_name());
			preparedStatement.setInt(3,  couponDTO.getCoupon_price());
			preparedStatement.setString(4,  couponDTO.getCoupon_use());
			
			int count = preparedStatement.executeUpdate( );
			if(count > 0) { connection.commit( );
			log.info("커밋되었습니다.");
			} else { connection.rollback( );
			log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("쿠폰 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return couponDTO;
	}

	@Override
	public CouponDTO couponUpdate(CouponDTO couponDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "update coupon set coupon_code = ?, coupon_type = ?, coupon_name = ?, coupon_price = ?, coupon_use = ? ";
			sql += "where coupon_code = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,  couponDTO.getCoupon_code());
			preparedStatement.setString(2,  couponDTO.getCoupon_type());
			preparedStatement.setString(3,  couponDTO.getCoupon_name());
			preparedStatement.setInt(4,  couponDTO.getCoupon_price());
			preparedStatement.setString(5,  couponDTO.getCoupon_use());
			preparedStatement.setInt(6,  couponDTO.getCoupon_code());
			
			int count = preparedStatement.executeUpdate( );
			if(count > 0) { connection.commit( );
			log.info("커밋되었습니다.");
			} else { connection.rollback( );
			log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("쿠폰 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return couponDTO;
	}

	@Override
	public CouponDTO couponDelete(int coupon_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "delete from coupon ";
			sql += " where coupon_code = ?";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, coupon_code);
			
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
		} 
		return null;
	}
}