package gl.assignment.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gl.assignment.springproject.dao.MyRepository;
import gl.assignment.springproject.model.Ticket;

@Service
public class DeleteService {

	@Autowired
	MyRepository repo;

	public String deleteOneTicket(Ticket ticket) {
		repo.delete(ticket);
		return "Deleted Ticket: " + ticket;
	}

	public String pruneTable() {
		repo.deleteAll();
		return "prune complete";
	}

	public String deleteAllThese(List<Ticket> ticket) {
		repo.deleteAll(ticket);
		return "Delete All Complete";
	}

	public String deleteAllInBatch() {
		repo.deleteAllInBatch();
		return "Delete All in Batch Completed";
	}

	public String deleteTicketById(Integer id) {
		repo.deleteById(id);
		return "Ticket with id: " + id + " is deleted";
	}
	
	public String deleteAllTheseInBatch(List<Ticket> tickets) {
		repo.deleteInBatch(tickets);
		return "Tickets deleted in batch";
	}

}
