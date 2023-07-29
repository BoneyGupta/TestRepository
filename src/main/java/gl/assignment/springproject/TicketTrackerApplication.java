package gl.assignment.springproject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import gl.assignment.springproject.model.Ticket;
import gl.assignment.springproject.service.CreateService;
import gl.assignment.springproject.service.DeleteService;
import gl.assignment.springproject.service.ExistService;
import gl.assignment.springproject.service.MyServiceImpl;
import gl.assignment.springproject.service.ReadService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TicketTrackerApplication implements CommandLineRunner {

	@Autowired
	MyServiceImpl mysvc;

	@Autowired
	ReadService readsvc;

	@Autowired
	CreateService createsvc;

	@Autowired
	ExistService existsvc;

	@Autowired
	DeleteService deletesvc;

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
		System.out.println("Spring Boot");
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Fetch all tickets -> {}", mysvc.getAllTickets(null));

		log.info("Persist a single ticket", createsvc.addSingleTicket(Ticket.builder().id(6).ticketTitle("Test Title 9")
				.ticketShortDesc("Test Desc 9").ticketCreatedOn("18-07-2023").ticketContent("Test Content 9").build()));

	}

	@SuppressWarnings("unused")
	private void readServiceImplMethods() {

		log.info("Fetch all tickets with no content-> {}", readsvc.getAllTicketsWithNoContent());

		Page<Ticket> page = readsvc.getTicketsPaged();
		List<Ticket> tickets = page.get().collect(Collectors.toList());
		log.info("Fetch paged tickets -> {}", tickets);

		Page<Ticket> page1 = readsvc.getTicketsCustomPaged(1, 2);
		List<Ticket> tickets1 = page1.get().collect(Collectors.toList());
		log.info("Fetch paged tickets -> {}", tickets1);

		log.info("Fetch ticket with latest Added order-> {}", readsvc.getTicketsWithLatestAddedOrder());
	}
}
