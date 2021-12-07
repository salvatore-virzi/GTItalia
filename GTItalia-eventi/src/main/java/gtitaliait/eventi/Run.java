package gtitaliait.eventi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gtitaliait.eventi.services.CarsServices;
import gtitaliait.eventi.services.TracksServices;
@Component
public class Run implements CommandLineRunner{
	@Autowired
	CarsServices carsServices;
	@Autowired
	TracksServices tracksServices;
	
	
	@Override
	public void run(String... args) throws Exception {
		carsServices.saveAll();
		tracksServices.saveAll();
	}

}
