package gtitaliait.eventi.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "event_ac")
public class EventAc extends Event{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String password;
	@ManyToOne
	TrackAc track;
	@ManyToMany
	List<CarsAc> car;
	Integer practiceSession;
	Integer qualifyingSession;
	Integer laps;
	Integer waitingForDeparture;
	@DateTimeFormat(pattern = "HH:mm")
	LocalTime hours;
	@Enumerated(EnumType.STRING)
	Meteo meteo;
	Integer ambientTemperature;
	@Enumerated(EnumType.STRING)
	Grip grip;
	
	boolean autoClutch;
	@Enumerated(EnumType.STRING)
	OnSerieOff tractionControl;
	@Enumerated(EnumType.STRING)
	OnSerieOff abs;
	boolean stabilityControl;
	boolean electricBlankets;
	
	Integer fuelConsumption;
	Integer damageRate;
	Integer tireWear;
	Integer wheelsOverTrack;
	Integer qualifyingTimeLimit;
	
	String description;
	Integer numberOfPlaces;
	Integer maxNumberOfPlaces;
	TipoPartenza tipoPartenza;
	String tutorialPartenza; 
	
//	Integer numberRace;
//	Integer numberQualifying;
//	Integer numberFreePractice;
	
	public String getTutorialPartenza() {
		String s ="";
		if(tipoPartenza==TipoPartenza.PARTENZA_DA_FERMO_A_GRIGLIA_INVERTITA) {
			return s= "Tutorial Partenza da fermo a griglia invertita"
					+ "Terminata la gara è bene fare una foto ai risultati per ricordarseli\r\n"
					+ "1) Saltare le eventuali prove libere\r\n"
					+ "2) Quando si è in qualifica, uscire dai box nell'ordine in cui si dovrà partire ed effettuare un giro pulito\r\n"
					+ "3) Prestare la massima attenzione a non superare chi è davanti e tenere un adeguato margine di distanza\r\n"
					+ "4) Quando si taglia il traguardo ci si ferma o si torna nuovamente ai box\r\n"
					+ "5) Non appena tutti hanno effettuato il loro giro, si saltano le qualifiche e si parte con la gara";
		} else if(tipoPartenza==TipoPartenza.PARTENZA_LANCIATA) {
			return s = "Tutorial Partenza Lanciata"
					+ "1) Si effettua il giro rimanendo compatti, non superando mai chi si ha davanti e mantenendo una guida pulita e fluida. NIENTE FRENATE BRUSCHE\r\n"
					+ "2) Quando si è in prossimità dell'ultima curva, è cura di chi è in pole position accertarsi che il gruppo sia compatto\r\n"
					+ "3) Si imposta un'andatura alla velocità indicata da manifesto con il proprio muso dell'auto che non deve superare il paraurti posteriore dell'auto davanti\r\n"
					+ "4) Appena scatta il giro 2 nella propria schermata di gara si può partire!";
			} else if(tipoPartenza==TipoPartenza.PARTENZA_LANCIATA_A_GRIGLIA_INVERTITA) {
				return s="Tutorial Partenza lanciata a griglia invertita\n"
						+ "Terminata la gara è bene fare una foto ai risultati per ricordarseli\r\n"
						+ "1) Saltare le eventuali prove libere\r\n"
						+ "2) Saltare le eventuali qualifiche\r\n"
						+ "3) Quando si spegne il semaforo, si parte nell'ordine in cui si dovrà partire e si impiegano le prime curve per verificare che l'ordine sia corretto\r\n"
						+ "4) Si termina il giro rimanendo vicini e seguendo la procedura per la Partenza lanciata";
			} else {
				return s="";
			}
	}

	
	public EventAc(Event event) {
		super(event.getNome(), event.getDate());
	}
	
	public EventAc() {
	}

}

