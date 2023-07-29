package gl.assignment.springproject.service;

import java.util.List;

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
		repo.flush();
		return "ticket saved";
	}
	
	public String addAllTickets(List<Ticket> tickets) {
		repo.saveAll(tickets);
		repo.flush();
		return "All tickets are saved";
	}
	
	public Ticket addTicketswithSaveAndFlush(Ticket ticket) {
		return repo.saveAndFlush(ticket);
	}
}
