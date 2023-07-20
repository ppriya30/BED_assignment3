package com.ticket_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket_management.Model.Ticket;
@Repository
public interface Ticket_repository  extends JpaRepository<Ticket, Integer>{

	
	
	@Query("SElECT t FROM Ticket t WHERE "+"t.ticket_title LIKE CONCAT('%',:query,'%')"+"Or t.description LIKE CONCAT('%',:query,'%')")
	List<Ticket> searchTicket(String query);
	
}
