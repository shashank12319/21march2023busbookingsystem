package com.wittybrains.busbookingsystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wittybrains.busbookingsystem.model.TravelSchedule;



@JsonInclude(value = Include.NON_NULL)
public class TravelScheduleDTO {

	private StationDTO source;
	private StationDTO destination;
	
	private String estimatedArrivalTime;
	private String estimatedDepartureTime;
	
	private Long id;

	public TravelScheduleDTO() {
		super();
	}

	public TravelScheduleDTO(TravelSchedule travelSchedule) {
		super();
		if (travelSchedule != null) {

			this.source = new StationDTO(travelSchedule.getSource());
			this.destination = new StationDTO(travelSchedule.getDestination());

			this.estimatedArrivalTime = travelSchedule.getEstimatedArrivalTime().toString();
			this.estimatedDepartureTime = travelSchedule.getEstimatedDepartureTime().toString();
		}

	}

	public TravelScheduleDTO(String string) {
		// TODO Auto-generated constructor stub
	}

	
	public StationDTO getSource() {
		return source;
	}

	public void setSource(StationDTO source) {
		this.source = source;
	}

	public StationDTO getDestination() {
		return destination;
	}

	public void setDestination(StationDTO destination) {
		this.destination = destination;
	}



	public String getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}

	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}

	public String getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(String estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}