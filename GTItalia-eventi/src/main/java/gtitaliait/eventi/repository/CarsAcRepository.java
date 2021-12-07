package gtitaliait.eventi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gtitaliait.eventi.model.CarsAc;

public interface CarsAcRepository extends JpaRepository<CarsAc, Long>{
	
CarsAc findByModel(String model); 
List<CarsAc> findByCategory(String category);

}
