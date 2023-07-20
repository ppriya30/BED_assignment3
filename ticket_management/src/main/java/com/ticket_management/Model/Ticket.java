package com.ticket_management.Model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date created_on;
	
	private String ticket_title;
	
	private String description;
	
	

	public Ticket(String ticket_title, String description) {
	
		this.ticket_title = ticket_title;
		this.description = description;
	}
	
	
}
