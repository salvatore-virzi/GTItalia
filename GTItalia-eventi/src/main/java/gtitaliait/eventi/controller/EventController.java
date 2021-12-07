package gtitaliait.eventi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gtitaliait.eventi.services.EventAcServices;
import gtitaliait.eventi.services.EventServices;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventServices eventServices;
	
	@Autowired
	EventAcServices eventAcServices;
	
	@GetMapping("/allEvent")
	public void allEvent() {
		if(eventServices.findAll().isEmpty()) {
			System.out.println("NO");
		} else {
		System.out.println(eventAcServices.findAll());
	}}
	
	
	@GetMapping("/ev")
	public String eve() {
		return eventAcServices.findAll().get(0).getNome();
	}
}
