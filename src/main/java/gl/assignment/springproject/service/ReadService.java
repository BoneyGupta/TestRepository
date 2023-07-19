package gl.assignment.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import gl.assignment.springproject.dao.MyRepository;
import gl.assignment.springproject.model.Ticket;

@Service
public class ReadService {

	@Autowired
	MyRepository repo;

	public List<Ticket> getAllTickets() {
		return repo.findAll();
	}
	
	public List<Ticket> getAllTicketsWithNoContent() {
		Ticket ticketWithNoContent=new Ticket();
		ticketWithNoContent.setTicketContent("");
		ExampleMatcher exampleMatcher= ExampleMatcher.matching()
				.withMatcher("ticketContent",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","ticketTitle","ticketShortDesc","ticketCreatedOn");
		Example<Ticket> example= Example.of(ticketWithNoContent,exampleMatcher);
		return repo.findAll(example);
	}
	
	public Page<Ticket> getTicketsPaged() {
		Pageable first2Records=PageRequest.of(0, 2);
		return repo.findAll(first2Records);
	}
	
	public Page<Ticket> getTicketsCustomPaged(int pageNumber,int numberOfRecordsOnAPage) {

		Pageable records=PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return repo.findAll(records);
	}
	
	public List<Ticket> getTicketsWithLatestAddedOrder() {
		return repo.findAll(Sort.by(Direction.DESC,"id"));
	}
}
