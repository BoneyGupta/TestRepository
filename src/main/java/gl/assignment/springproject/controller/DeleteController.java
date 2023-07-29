package gl.assignment.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.model.Ticket;
import gl.assignment.springproject.service.DeleteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/deletesvc")
public class DeleteController {
	
	@Autowired
	DeleteService deletesvc;
	
	@Operation(summary = "Delete One Ticket", description = "This API allows you to delete one ticket from Ticket table")
	@DeleteMapping("/deleteOneTicket")
	public String deleteOneTicket(Ticket ticket) {
		return deletesvc.deleteOneTicket(ticket);
	}
	
	@Operation(summary = "Prune Table",description = "This API allows you to prune Ticket table")
	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deletesvc.pruneTable();
	}
	
	@Operation(summary = "Delete All These Tickets", description = "This API allows you to delete a list of tickets from Ticket table")
	@PostMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List<Ticket> tickets) {
		return deletesvc.deleteAllThese(tickets);
	}
	
	@Operation(summary = "Delete All Tickets In Batch Mode",description = "This API allows you to delete all tickets present in the Ticket table in batch mode")
	@DeleteMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		return deletesvc.deleteAllInBatch();
	}
		
	@Operation(summary = "Delete Ticket By Id",description = "This API allows you to delete single ticket at a time by ID")
	@DeleteMapping("/deleteTicketById")
	public String deleteTicketById(Integer id) {
		return deletesvc.deleteTicketById(id);
	}
	
	@PostMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch( @RequestBody List<Ticket> tickets) {
		return deletesvc.deleteAllTheseInBatch(tickets);
	}
}
