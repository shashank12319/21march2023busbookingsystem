package com.wittybrains.busbookingsystem.dto;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wittybrains.busbookingsystem.model.Booking;
@JsonInclude(value = Include.NON_NULL)
public class BookingDTO {
	private Long bookingId;
	private LocalDate dateOfBooking;
	private TravelScheduleDTO schedule;
	
	
	private BusDTO bus;
	private String routeInfo;
    
	private UserDTO user;
	
	private Double totalAmount;
	private String seatStatus;
	
	public BookingDTO() {
		super();
	}

	public UserDTO getUser() {
		return user;
	}

	
	public BookingDTO(Booking booking) {
		this.bookingId = booking.getBookingId();
		this.dateOfBooking = booking.getDateOfBooking();
		this.schedule = new TravelScheduleDTO(booking.getSchedule());
		
        this.user=new UserDTO(booking.getUser());
		this.totalAmount = booking.getTotalAmount();
		
	}



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

	public TravelScheduleDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(TravelScheduleDTO schedule) {
		this.schedule = schedule;
	}



	public BusDTO getBus() {
		return bus;
	}

	public void setBus(BusDTO bus) {
		this.bus = bus;
	}

	public String getRouteInfo() {
		return routeInfo;
	}

	public void setRouteInfo(String routeInfo) {
		this.routeInfo = routeInfo;
	}

	public void setUser(UserDTO userDTO) {
		this.user = userDTO;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String bookingStatus) {
		this.seatStatus = bookingStatus;
	}


}