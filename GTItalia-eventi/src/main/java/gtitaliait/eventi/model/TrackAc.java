package gtitaliait.eventi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "track_list_ac")
public class TrackAc extends Track{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	String urlPhoto;
	@OneToMany
	List<Event> event;
	public String getNome() {
		return nome;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	@Override
	public String toString() {
		return nome + " " + urlPhoto;
	}
	
}
