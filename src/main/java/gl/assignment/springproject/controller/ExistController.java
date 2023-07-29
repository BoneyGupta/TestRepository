package gl.assignment.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gl.assignment.springproject.service.ExistService;

@RestController
@RequestMapping("/existsService")
public class ExistController {
	
	@Autowired
	ExistService existsvc;
	
	@GetMapping("/checkTicketExistsById")
	public boolean checkTicketExistsById(int id){
		return existsvc.checkTicketExistsById(id);		
	}
	
	@GetMapping("/checkTicketExistsByExample")
	public boolean checkTicketExistsByExample(String ticketContent) {
		return existsvc.checkTicketExistsByExample(ticketContent);
	}

}
