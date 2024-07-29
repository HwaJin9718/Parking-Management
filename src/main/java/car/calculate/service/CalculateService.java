package car.calculate.service;

import java.util.ArrayList;

import car.calculate.dto.CalculateDTO;

public interface CalculateService {
	public ArrayList<CalculateDTO> calculateSearchById(int member_code);
	public void calculateUpdate(ArrayList<CalculateDTO> arrayList);
}
