package gtitaliait.eventi.csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import gtitaliait.eventi.model.Cars;
import gtitaliait.eventi.model.CarsAc;
import gtitaliait.eventi.model.CarsAcc;

public class FileCars {

	private final String PATH_FILE = "D:\\salvo\\eclipe\\eclipse-workspace-6\\GTItalia-eventi\\src\\main\\resources\\static\\csv-file\\cars.csv";

	public List<Cars> readFileGame() {
		File fileCars = new File(PATH_FILE);
		String readFile;
		List<Cars> listCars = new ArrayList<>();

		try {
			readFile = FileUtils.readFileToString(fileCars, "UTF-8");
			List<String> listFileCars = Arrays.asList(readFile.split("\n"));
			int n = 0;
			for (String p : listFileCars) {
				if (n != 0) {
					String[] split = p.split(",");
					if (split[0].equalsIgnoreCase("AC")) {
						CarsAc cars = new CarsAc();
						cars.setGame(split[0]);
						cars.setBrand(split[1]);
						cars.setModel(split[2]);
						cars.setCategory(split[3]);
						listCars.add(cars);
					} else if (split[0].equalsIgnoreCase("ACC")) {
						CarsAcc cars = new CarsAcc();
						cars.setGame(split[0]);
						cars.setBrand(split[1]);
						cars.setModel(split[2]);
						cars.setCategory(split[3]);
						listCars.add(cars);
					}
				} else {
					n++;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCars;

	}

}
