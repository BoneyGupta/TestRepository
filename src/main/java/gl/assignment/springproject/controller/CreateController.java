package gl.assignment.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.model.Ticket;
import gl.assignment.springproject.service.CreateService;

@RestController
@RequestMapping("/tickets/create")
public class CreateController {

	@Autowired
	CreateService createsvc; 
	
	@PostMapping("/")
	public String createSingleTicket(Ticket tkt) {
		createsvc.addSingleTicket(tkt);
		return	tkt.toString();
	}
}
