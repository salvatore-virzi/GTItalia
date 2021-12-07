package gtitaliait.eventi.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@JsonSerialize(using = CustomObjectSerializer.class)
@Data
public class EventGenericAc {
	Long id;
	
	//Event
	String nome;
	LocalDate date;
	
	//EventAc
	String password;
	TrackAc track;
	List<CarsAc> car;
	Integer practiceSession;
	Integer qualifyingSession;
	Integer laps;
	Integer waitingForDeparture;
	LocalTime hours;
	Meteo meteo;
	Integer ambientTemperature;
	Grip grip;
	boolean autoClutch;
	OnSerieOff tractionControl;
	OnSerieOff abs;
	boolean stabilityControl;
	boolean electricBlankets;
	Integer fuelConsumption;
	Integer damageRate;
	Integer tireWear;
	Integer wheelsOverTrack;
	Integer qualifyingTimeLimit;
}
