package gtitaliait.eventi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track_list_acc")
public class TrackAcc extends Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	String urlPhoto;

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
