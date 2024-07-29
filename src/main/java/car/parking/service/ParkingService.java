package car.parking.service;

import java.util.ArrayList;

import car.parking.dto.ParkingDTO;

public interface ParkingService {
	
	public ArrayList<ParkingDTO> parkingSelectAll(int member_code);
	
	public ArrayList<ParkingDTO> parkingSelectAdmin();
	
	public ParkingDTO parkingSelectDetail(int parking_code);
	
	public void parkingInsert(ParkingDTO parkingDTO);
	
	public void parkingUpdate(ParkingDTO parkingDTO);
	
	public void parkingDelete(int parking_code);
	
	public void parkingApprove(ParkingDTO parkingDTO);

}
