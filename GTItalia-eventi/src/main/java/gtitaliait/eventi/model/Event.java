package gtitaliait.eventi.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	LocalDate date;
	int numberDrivers;
	@OneToMany
	List<Result> results;

	public Event() {}
	
	public Event(String nome, LocalDate date) {
		this.nome = nome;
		this.date = date;
	}
	public Event(String nome, LocalDate date, int numberDrivers, List<Result> results) {
		this.nome = nome;
		this.date = date;
		this.numberDrivers = numberDrivers;
		this.results = results;
	}

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDate() {
		return date;
	}

	public int getNumberDrivers() {
		return numberDrivers;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setNumberDrivers(int numberDrivers) {
		this.numberDrivers = numberDrivers;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}	
}
