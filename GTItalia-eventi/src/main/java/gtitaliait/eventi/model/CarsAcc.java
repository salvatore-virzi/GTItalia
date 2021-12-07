package gtitaliait.eventi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_list_acc")
public class CarsAcc extends Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String game;
	String brand;
	String model;
	String category;

	public Long getId() {
		return id;
	}

	public String getGame() {
		return game;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getCategory() {
		return category;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return getGame() + " " + getBrand() + "  " + getModel() + " " + getCategory();
	}

}
