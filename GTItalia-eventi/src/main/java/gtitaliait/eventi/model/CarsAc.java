package gtitaliait.eventi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_list_ac")
public class CarsAc extends Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String game;
	String brand;
	String model;
	String category;
	@ManyToMany
	List<Event> event;

	public String getName() {
		return brand + " " + model;
	}
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
		return getName();
	}
}
