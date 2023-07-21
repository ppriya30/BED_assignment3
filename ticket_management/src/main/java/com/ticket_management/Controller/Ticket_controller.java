package com.ticket_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket_management.Model.Ticket;
import com.ticket_management.Service.Ticket_Service;

@Controller
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
	
	//-----------------
	
	@GetMapping("/list")
	public String  listTicket(Model ticketModel ) {   //thymeleaf
		
		List <Ticket> list_ticket=ticket_Service.getAllticket();
		ticketModel.addAttribute("tickets", list_ticket);
		return "collection/list_ticket";//page path
	}
	
	
	
	@GetMapping("/newTicket")//correct
	public String showForAddticket(Model ticketModel)
	{
		Ticket details=new Ticket();
		ticketModel.addAttribute("tickets",details);
		return "collection/add_ticket";
	}
	
	
	@GetMapping("/editticket")
	public String editticket(@RequestParam("tic_id")int t_id,Model tic_model) {
		Ticket tic1= ticket_Service.ticketDetail(t_id);
		tic_model.addAttribute("tickets", tic1);
		return "collection/editticket";
	}
	
	
	
	
	
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("tickets") Ticket tic) {
		ticket_Service.addTicket(tic);
		return "redirect:/ticket/list";
	}
	
	
	@GetMapping("/deleteticket")
	public String deleteticket(@RequestParam("tick_id") int t_id) {
		ticket_Service.deleteTicket(t_id);
		return "redirect:/ticket/list";
	}
	
	
	@PostMapping("/Searchticket")
	public String Searchticket(@RequestParam("Search")String search_tick ,Model model ) {
		
		List <Ticket> search_list_ticket=ticket_Service.searchTicket(search_tick);
		model.addAttribute("S_tickets", search_list_ticket);
		return "collection/list_ticket";
	}

}
