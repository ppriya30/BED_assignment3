package com.ticket_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ticket_management.Model.Ticket;
import com.ticket_management.Service.Ticket_Service;

@RestController
@RequestMapping("/ticket")
public class Ticket_controller {
	
	@Autowired
	Ticket_Service ticket_Service;
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody Ticket ticket1) {
		return ticket_Service.addTicket(ticket1);
	}
	
	
	@GetMapping("/ticketDetail")
	public Ticket ticketDetail(@RequestParam("ticket_id") int tic_id) {
		return ticket_Service.ticketDetail(tic_id);
	}
	
	@GetMapping("/getAllticket")
	public List<Ticket> getAllticket(){
		return ticket_Service.getAllticket();
	}
	
	@PutMapping("/editTicket")
	public Ticket editTicket(@RequestParam("ticket_id")int tic_id , @RequestBody Ticket ticket1) {
		return ticket_Service.editTicket(tic_id, ticket1);
	}
	
	@DeleteMapping("/deleteTicket")
	public String deleteTicket(@RequestParam("ticket_id") int tic_id) {
		ticket_Service.deleteTicket(tic_id);
		return "Ticket info deleted";
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Ticket>> searchTicket(@RequestParam("query") String query){
		return ResponseEntity.ok(ticket_Service.searchTicket(query));
	}
	
	
	
	

}
