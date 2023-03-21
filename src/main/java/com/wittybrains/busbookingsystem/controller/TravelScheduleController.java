package com.wittybrains.busbookingsystem.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wittybrains.busbookingsystem.dto.TravelScheduleDTO;
import com.wittybrains.busbookingsystem.model.TravelSchedule;
import com.wittybrains.busbookingsystem.service.TravelScheduleService;

@RestController
@RequestMapping("/schedules")
@JsonInclude(value = Include.NON_NULL)
public class TravelScheduleController {

	private static final Logger logger = LoggerFactory.getLogger(TravelScheduleController.class);
	private final TravelScheduleService travelScheduleService;
	
	public TravelScheduleController(TravelScheduleService travelScheduleService) {
		this.travelScheduleService = travelScheduleService;
	}

	@GetMapping("avalibility")
	public ResponseEntity<TravelScheduleResponseWrapper> getSchedules(
			@RequestParam(value = "sourceCode",required=false) String sourceCode,
			@RequestParam(value = "destinationCode",required=false) String destinationCode, @RequestParam("date") String date) {
		return travelScheduleService.getAvailableSchedule(sourceCode, destinationCode, date);
	}

    @GetMapping
    public List<TravelSchedule> getTravelSchedulesBySource(@RequestParam("source") Long sourceStationId) {
        return travelScheduleService.getTravelSchedulesBySource(sourceStationId);
    }


	@PostMapping
	public ResponseEntity<TravelScheduleResponseWrapper> createSchedule(
			@RequestBody TravelScheduleDTO travelScheduleDTO) throws ParseException {
		if (travelScheduleService.createSchedule(travelScheduleDTO)) {
			logger.info("Successfully created travel schedule: {}", travelScheduleDTO);
			TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper(
					"Successfully created travel schedule", null);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			logger.error("Failed to create travel schedule: {}", travelScheduleDTO);
			TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper(
					"Unable to create travel schedule", null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}