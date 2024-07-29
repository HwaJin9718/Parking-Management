package car.ticket.dao;

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

import car.ticket.dto.TicketDTO;
import car.ticket.service.TicketService;

public class TicketDAO implements TicketService {
	private static Log log = LogFactory.getLog(TicketDAO.class);
	@Override
	public ArrayList<TicketDTO> ticketSearch() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<TicketDTO> arrayList = new ArrayList<TicketDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select ticket_code, ticket_name, ticket_type, ticket_days, ticket_time, ticket_price from ticket ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TicketDTO ticketDTO = new TicketDTO();
				ticketDTO.setTicket_code(resultSet.getInt("ticket_code"));
				ticketDTO.setTicket_name(resultSet.getString("ticket_name"));
				ticketDTO.setTicket_type(resultSet.getString("ticket_type"));
				ticketDTO.setTicket_days(resultSet.getString("ticket_days"));
				ticketDTO.setTicket_time(resultSet.getString("ticket_time"));
				ticketDTO.setTicket_price(resultSet.getString("ticket_price"));
				arrayList.add(ticketDTO);
			}
			resultSet.getRow();
			if(resultSet.getRow() == 0) {
				log.info("등록한 정기권이 없습니다. 정기권을 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("정기권 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public TicketDTO ticketDetailSearch(int ticket_code) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    TicketDTO ticketDTO = new TicketDTO();
	    try {
	        Context context = new InitialContext();
	        DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = datasource.getConnection();
	        String sql = "select ticket_code, ticket_type, ticket_name, ticket_days, ticket_time, ticket_price from ticket ";
	        sql += " where ticket_code = ? ";
	        log.info("SQL 확인 - " + sql);
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, ticket_code);
	        resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()) {
	            ticketDTO.setTicket_code(resultSet.getInt("ticket_code"));
	            ticketDTO.setTicket_type(resultSet.getString("ticket_type"));
	            ticketDTO.setTicket_name(resultSet.getString("ticket_name"));
	            ticketDTO.setTicket_days(resultSet.getString("ticket_days"));
	            ticketDTO.setTicket_time(resultSet.getString("ticket_time"));
	            ticketDTO.setTicket_price(resultSet.getString("ticket_price"));
	        }
	    } catch (Exception e) {
	        log.info("정기권 상세 조회 실패" + e);
	    } finally {
	        try {
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    return ticketDTO;
	}


	@Override
	public TicketDTO ticketInsert(TicketDTO ticketDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "insert into ticket(ticket_code, ticket_type, ticket_name, ticket_days, ticket_time, ticket_price ) ";
			sql += " values(ticket_seq.NEXTVAL, ?, ?, ?, ?, ? )";
			log.info(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ticketDTO.getTicket_type());
			preparedStatement.setString(2, ticketDTO.getTicket_name());
			preparedStatement.setString(3, ticketDTO.getTicket_days());
			preparedStatement.setString(4, ticketDTO.getTicket_time());
			preparedStatement.setString(5, ticketDTO.getTicket_price());
			
			
			
			int count = preparedStatement.executeUpdate();
			if(count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 입력 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ticketDTO;
	}

	@Override
	public TicketDTO ticketUpdate(TicketDTO ticketDTO) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        Context context = new InitialContext();
	        DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc");
	        connection = datasource.getConnection();
	        String sql = "update ticket set ticket_type= ?, ticket_name= ?, ticket_days= ?, ticket_time= ?, ticket_price= ? ";
	        sql += " where ticket_code = ?";
	        log.info("SQL 확인 - " + sql);
	        preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, ticketDTO.getTicket_type());
	        preparedStatement.setString(2, ticketDTO.getTicket_name());
	        preparedStatement.setString(3, ticketDTO.getTicket_days());
	        preparedStatement.setString(4, ticketDTO.getTicket_time());
	        preparedStatement.setString(5, ticketDTO.getTicket_price());
	        preparedStatement.setInt(6, ticketDTO.getTicket_code()); 
	        
	        int count = preparedStatement.executeUpdate();
	        if (count > 0) {
	            connection.commit();
	            log.info("커밋되었습니다.");
	        } else {
	            connection.rollback();
	            log.info("롤백되었습니다.");
	        }
	    } catch (Exception e) {
	        log.info("부서 수정 실패 - " + e);
	    } finally {
	        try {
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return ticketDTO;
	}



	@Override
	public TicketDTO ticketDelete(int ticket_code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "delete from ticket ";
			sql += " where ticket_code = ? ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ticket_code);
			
			int count = preparedStatement.executeUpdate();
			if(count > 0) {
				connection.commit();
				log.info("커밋되었습니다.");
			} else {
				connection.rollback();
				log.info("롤백되었습니다.");
			}
		} catch (Exception e) {
			log.info("부서 삭제 실패 - " + e);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<TicketDTO> ticketlistdays() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<TicketDTO> arrayList = new ArrayList<TicketDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select ticket_name, ticket_type, ticket_days, ticket_price from ticket ";
			sql += " where ticket_type = '월권' ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				TicketDTO ticketDTO = new TicketDTO();
				ticketDTO.setTicket_name(resultSet.getString("ticket_name"));
				ticketDTO.setTicket_type(resultSet.getString("ticket_type"));
				ticketDTO.setTicket_days(resultSet.getString("ticket_days"));
				ticketDTO.setTicket_price(resultSet.getString("ticket_price"));
				log.info("ticketDTO - " + ticketDTO);
				arrayList.add(ticketDTO);
				
			}
			resultSet.getRow();
			if(resultSet.getRow() == 0) {
				log.info("등록한 정기권이 없습니다. 정기권을 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("정기권 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	@Override
	public ArrayList<TicketDTO> ticketlisttime() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<TicketDTO> arrayList = new ArrayList<TicketDTO>();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select ticket_name, ticket_type, ticket_time, ticket_price from ticket ";
			sql += " where ticket_type = '시간권' ";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TicketDTO ticketDTO = new TicketDTO();
				ticketDTO.setTicket_name(resultSet.getString("ticket_name"));
				ticketDTO.setTicket_type(resultSet.getString("ticket_type"));
				ticketDTO.setTicket_time(resultSet.getString("ticket_time"));
				ticketDTO.setTicket_price(resultSet.getString("ticket_price"));
				log.info("ticketDTO - " + ticketDTO);
				arrayList.add(ticketDTO);
			}
			resultSet.getRow();
			if(resultSet.getRow() == 0) {
				log.info("등록한 시간권이 없습니다. 시간권을 등록해 주세요");
			}
		} catch (Exception e) {
			log.info("정기권 조회 실패 - " + e);
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	



	

}
