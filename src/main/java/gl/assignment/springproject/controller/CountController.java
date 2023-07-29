package gl.assignment.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.service.CountService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/countService")
public class CountController {
	
	@Autowired
	CountService countsvc;
	
	@Operation(summary="Count Tickets",description="Counts the number of tickets in the tickets table")
	@GetMapping("/countTickets")
	public long countTickets() {
		return countsvc.countTickets();
	}
	
	@Operation(summary="Count Tickets with No Content",description="Counts the number of Tickets with no content")
	@GetMapping("/countTicketsWithZeroContent")
	public long countTicketsWithZeroContent() {
		return countsvc.countTicketsWithZeroContent();
	}

}
