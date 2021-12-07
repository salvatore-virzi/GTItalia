package gtitaliait.eventi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtitaliait.eventi.model.Event;
import gtitaliait.eventi.repository.EventRepository;

@Service
public class EventServices {

	@Autowired
	EventRepository eventRepository;
	
	public void saveEvent(Event event) {
		eventRepository.save(event);
	}
	
	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	public Event findNome(String nome) {
		return eventRepository.findByNome(nome);
	}
}
