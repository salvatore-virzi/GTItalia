package gtitaliait.eventi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gtitaliait.eventi.model.Event;
import gtitaliait.eventi.model.EventAc;
import gtitaliait.eventi.repository.EventAcRepository;
import gtitaliait.eventi.repository.EventRepository;

@Service
public class EventAcServices {
	
@Autowired
EventAcRepository eventAcRepository;

@Autowired
EventRepository eventRepository;

	public void save(EventAc eventAc) {
		eventAcRepository.save(eventAc);
	}

	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
}
