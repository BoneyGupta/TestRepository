package gl.assignment.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.model.Ticket;
import gl.assignment.springproject.service.CreateService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/createService")
public class CreateController {

	@Autowired
	CreateService createsvc; 
	
	@Operation(summary = "Add Single Ticket", description = "This API allows you to add a single ticket to Ticket table")
	@PostMapping("/addSingleTicket")
	public String addSingleTicket(Ticket ticket) {
		return createsvc.addSingleTicket(ticket);
	}
	
	@Operation(summary = "Add Multiple Libraries", description = "This API allows you to add multiple tickets to Ticket table")
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<Ticket> tickets) {
		return createsvc.addAllTickets(tickets);
	}
		
	@Operation(summary = "Add Single Ticket", description = "This API allows you to add single ticket to Ticket table and it internally uses a combined method of save and flush")
	@PostMapping("/addLibrararywithSaveAndFlush")
	public Ticket addLibrararywithSaveAndFlush(Ticket ticket) {
		return createsvc.addTicketswithSaveAndFlush(ticket);
	}
}
