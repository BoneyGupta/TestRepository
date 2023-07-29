package gl.assignment.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import gl.assignment.springproject.dao.MyRepository;
import gl.assignment.springproject.model.Ticket;

@Service
public class CountService {
	
	@Autowired
	MyRepository repo;
	
	public long countTickets() {
		return repo.count();
	}
	
	public long countTicketsWithZeroContent() {
		Ticket ticket=new Ticket();
		ticket.setTicketContent("");
		ExampleMatcher exampleMatcher= ExampleMatcher.matching().withMatcher("ticketContent", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnoreCase("id","ticketTitle","ticketCreatedOn","ticketShortDesc");
		Example<Ticket> example=Example.of(ticket,exampleMatcher);
		return repo.count(example);
	}

}
