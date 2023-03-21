package com.wittybrains.busbookingsystem.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private LocalDate dateOfBooking;
	@OneToOne
	private TravelSchedule schedule;

	
	

	@ManyToOne
	private User user;
	private Double totalAmount;
	

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public TravelSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(TravelSchedule schedule) {
		this.schedule = schedule;
	}

	



   

	public Double getTotalAmount() {
		return totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public LocalDate getDate() {
		return this.dateOfBooking;
	}

	

}
