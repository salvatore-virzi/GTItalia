package gtitaliait.eventi.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gtitaliait.eventi.model.CarsAc;
import gtitaliait.eventi.model.Event;
import gtitaliait.eventi.model.EventAc;
import gtitaliait.eventi.model.Grip;
import gtitaliait.eventi.model.Meteo;
import gtitaliait.eventi.model.OnSerieOff;
import gtitaliait.eventi.model.TipoPartenza;
import gtitaliait.eventi.model.TrackAc;
import gtitaliait.eventi.services.CarsServices;
import gtitaliait.eventi.services.EventAcServices;
import gtitaliait.eventi.services.EventServices;
import gtitaliait.eventi.services.TracksServices;

@RestController
@RequestMapping("/eventAc")
public class EventAcController {
	
	@Autowired
	EventAcServices eventAcServices;
	@Autowired
	EventServices eventServices;
	@Autowired
	CarsServices carsServices;
	@Autowired
	TracksServices tracksServices;

	@GetMapping("/new")
	public ModelAndView createEvent() {
		ModelAndView m = new ModelAndView("create_event_ac");
		List<TrackAc> track = tracksServices.getAll();
		List<CarsAc> car= carsServices.getAll();
		m.addObject("track", track);
		m.addObject("car", car);
		return m;	
	}
	
	@PostMapping("/create")
	public ModelAndView createEvent(
			@RequestParam String nome, @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate date,
			String password, String track, Integer practiceSession, String cars, String description, TipoPartenza tipoPartenza,
			Integer qualifyingSession, Integer laps, Integer waitingForDeparture, @DateTimeFormat(pattern = "HH:mm") LocalTime hours,
			Meteo meteo, Integer ambientTemperature, Grip grip, boolean autoClutch, OnSerieOff tractionControl,
			OnSerieOff abs, boolean stabilityControl, boolean electricBlankets, Integer fuelConsumption, 
			Integer damageRate, Integer tireWear, Integer wheelsOverTrack, Integer qualifyingTimeLimit, 
			Integer numberOfPlaces, Integer maxNumberOfPlaces) {	
		List<CarsAc> auto = new ArrayList<>();
		String split[] = cars.split(",");
		for (int i= 0; i < split.length; i++) {
			CarsAc c= carsServices.findByModel(split[i]);
			auto.add(c);
		}
		Event event = new Event();
			event.setNome(nome);
			event.setDate(date);
		EventAc eventAc = new EventAc(event);
		eventAc.setMaxNumberOfPlaces(maxNumberOfPlaces);
		eventAc.setNumberOfPlaces(numberOfPlaces);
		eventAc.setTipoPartenza(tipoPartenza);
		eventAc.setDescription(description);
			eventAc.setPassword(password);
			eventAc.setTrack(tracksServices.searchTrackForName(track));
			eventAc.setCar(auto);
			eventAc.setPracticeSession(practiceSession);
			eventAc.setQualifyingSession(qualifyingSession);
			eventAc.setLaps(laps);
			eventAc.setWaitingForDeparture(waitingForDeparture);
			eventAc.setHours(hours);
			eventAc.setMeteo(meteo);
			eventAc.setAmbientTemperature(ambientTemperature);
			eventAc.setGrip(grip);
			eventAc.setAutoClutch(autoClutch);
			eventAc.setTractionControl(tractionControl);
			eventAc.setAbs(abs);
			eventAc.setStabilityControl(stabilityControl);
			eventAc.setElectricBlankets(electricBlankets);
			eventAc.setFuelConsumption(fuelConsumption);
			eventAc.setDamageRate(damageRate);
			eventAc.setTireWear(tireWear);
			eventAc.setWheelsOverTrack(wheelsOverTrack);
			eventAc.setQualifyingTimeLimit(qualifyingTimeLimit);
			eventAcServices.save(eventAc);
			return allEvent();
	}	
	@GetMapping("/allEvent")
	public ModelAndView allEvent() {
		ModelAndView m = new ModelAndView("event_ac_all");
		m.addObject("list", eventAcServices.findAll());
		return m;
		}
	
	@GetMapping("/{name}")
	public ModelAndView viewEvent(@PathVariable(required = true) String name) {
		ModelAndView m = new ModelAndView("event_ac");
		m.addObject("event", eventServices.findNome(name));
		return m;
	}
	
	
}