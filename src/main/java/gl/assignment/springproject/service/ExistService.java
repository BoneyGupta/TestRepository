package gl.assignment.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import gl.assignment.springproject.dao.MyRepository;
import gl.assignment.springproject.model.Ticket;

@Service
public class ExistService {

	@Autowired
	MyRepository repo;

	public boolean checkTicketExistsById(Integer id) {
		return repo.existsById(id);
	}

	public boolean checkTicketExistsByExample(String ticketContent) {
		Ticket ticket=new Ticket();
		ticket.setTicketContent(ticketContent);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher(ticketContent, ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","ticketTitle","ticketCreatedOn","ticketShortDesc");
		Example<Ticket> example= Example.of(ticket,exampleMatcher);
		return repo.exists(example);
		
	}

}
