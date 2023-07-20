package com.ticket_management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket_management.Model.Ticket;
import com.ticket_management.Repository.Ticket_repository;

@Service
public class Ticket_Service {
	
	@Autowired
	Ticket_repository ticket_repository;

	public Ticket addTicket(Ticket ticket1) {
		
		return ticket_repository.save(ticket1);
	}

	public Ticket ticketDetail(int tic_id) {
		
		return ticket_repository.findById(tic_id).get();
	}

	public List<Ticket> getAllticket() {
		return ticket_repository.findAll();
	}

	public Ticket editTicket(int tic_id, Ticket ticket1) {
		Ticket dbticket =ticketDetail(tic_id);
		dbticket.setDescription(ticket1.getDescription());
		dbticket.setTicket_title(ticket1.getTicket_title());
		return ticket_repository.save(dbticket);
	}

	public void deleteTicket(int tic_id) {
		ticket_repository.deleteById(tic_id);
	}
	
	public List<Ticket> searchTicket(String query){
		List<Ticket>s_Ticket= ticket_repository.searchTicket(query);
		return s_Ticket;
	}

}
