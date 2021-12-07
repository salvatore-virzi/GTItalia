package gtitaliait.eventi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtitaliait.eventi.csv.FileCars;
import gtitaliait.eventi.model.Cars;
import gtitaliait.eventi.model.CarsAc;
import gtitaliait.eventi.model.CarsAcc;
import gtitaliait.eventi.repository.CarsAcRepository;
import gtitaliait.eventi.repository.CarsAccRepository;

@Service
public class CarsServices {
	@Autowired
	CarsAcRepository carsAcRepository;
	@Autowired
	CarsAccRepository carsAccRepository;
	
	FileCars fileCars = new FileCars(); ;
	
	public void saveAll() {
		for(Cars c : fileCars.readFileGame()) {
			if(c instanceof CarsAc) {
				carsAcRepository.save((CarsAc) c);
			} else if(c instanceof CarsAcc) {
				carsAccRepository.save((CarsAcc)c);
			}
		}	
	}
	
	public List<CarsAc> getAll(){
		return carsAcRepository.findAll();
	}
	
	public CarsAc findByModel(String model) {
		return carsAcRepository.findByModel(model);
	}
	
	public List<CarsAc> findCategory(String category){
		return carsAcRepository.findByCategory(category);
	}
}
