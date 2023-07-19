package gl.assignment.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.assignment.springproject.dao.MyRepository;
import gl.assignment.springproject.model.Ticket;

@Service
public class CreateService {

	@Autowired
	MyRepository repo;
	
	public String addSingleTicket(Ticket ticket) {
		repo.save(ticket);
		return "ticket saved";
	}
}
