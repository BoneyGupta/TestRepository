package gl.assignment.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.model.Ticket;
import gl.assignment.springproject.service.ReadService;

@RestController
@RequestMapping("/tickets/read")
public class ReadController {
	
	@Autowired
	ReadService readsvc;
	
	@GetMapping("/all")
	public List<Ticket> getAllTickets(){
		return readsvc.getAllTickets();
	}
	
	@GetMapping("/nocontent")
	public List<Ticket> getTicketsWithNoContent(){
		return readsvc.getAllTicketsWithNoContent();
	}
}
