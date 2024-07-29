package car.parkingsearch.dao;

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

import car.parkingsearch.dto.ParkingSearchDTO;
import car.parkingsearch.service.ParkingSearchService;

public class ParkingSearchDAO implements ParkingSearchService {
	private static Log log = LogFactory.getLog(ParkingSearchDAO.class);
	@Override
	public ArrayList<ParkingSearchDTO> parkingSearch() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<ParkingSearchDTO>  arrayList = new ArrayList<ParkingSearchDTO> ();
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select parking_code, parking_name, parking_address, parking_latitude, parking_longitude, parking_base_fee, parking_hourly_rate, parking_type from parking ";
			log.info(sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ParkingSearchDTO parkingSearchDTO = new ParkingSearchDTO();
				parkingSearchDTO.setParking_code(resultSet.getInt("parking_code"));
				log.info("parking_code - " + parkingSearchDTO.getParking_code());
				parkingSearchDTO.setParking_name(resultSet.getString("parking_name"));
				parkingSearchDTO.setParking_address(resultSet.getString("parking_address"));
				parkingSearchDTO.setParking_latitude(resultSet.getDouble("parking_latitude"));
				parkingSearchDTO.setParking_longitude(resultSet.getDouble("parking_longitude"));
				parkingSearchDTO.setParking_base_fee(resultSet.getString("parking_base_fee"));
				parkingSearchDTO.setParking_hourly_rate(resultSet.getString("parking_hourly_rate"));
				parkingSearchDTO.setParking_type(resultSet.getString("parking_type"));
				arrayList.add(parkingSearchDTO);
			}
			resultSet.getRow();
			if(resultSet.getRow() == 0) {
				log.info("등록된 정보 없음");
			}
		} catch (Exception e) {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return arrayList;
	}

	

}
