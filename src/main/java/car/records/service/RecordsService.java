package car.records.service;

import java.util.ArrayList;

import car.records.dto.RecordsDTO;

public interface RecordsService {
	
	public ArrayList<RecordsDTO> recordsSelectUser(int member_code);
	
	public ArrayList<RecordsDTO> recordsSelectParkingCode(int member_code);
	
	public ArrayList<RecordsDTO> recordsSelectParking(int parking_code);
	
	public RecordsDTO recordsSelectDetailUser(int records_code);
	
	public RecordsDTO recordsSelectDetailParking(int records_code);
	
	public void recordsInsert(RecordsDTO recordsDTO);
	
	public void recordsUpdate(RecordsDTO recordsDTO);
	
	public void recordsDelete(int records_code);

	

}
