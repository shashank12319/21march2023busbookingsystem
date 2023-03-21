package com.wittybrains.busbookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.model.Bus;
import com.wittybrains.busbookingsystem.repository.BusRepository;

@Service
public class BusService {

	private final BusRepository busRepository;
	private final Logger logger = LoggerFactory.getLogger(BusService.class);

	public BusService(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	public List<BusDTO> createBuses(List<BusDTO> busList) {
		List<BusDTO> createdBuses = new ArrayList<>();

		for (BusDTO busDTO : busList) {

			if (StringUtils.isBlank(busDTO.getDestination()) || StringUtils.isBlank(busDTO.getNumber())
					|| StringUtils.isBlank(busDTO.getSource()) || StringUtils.isBlank(busDTO.getType())
					|| StringUtils.isBlank(busDTO.getTiming())) {
				throw new IllegalArgumentException(
						"Please provide all the details for the bus either field is null or empty");
			}
			Bus bus = new Bus();
			//bus.setDestination(busDTO.getDestination());
			//bus.setSource(busDTO.getSource());
			bus.setType(busDTO.getType());
			//bus.setTiming(busDTO.getTiming());

			busRepository.save(bus);

			createdBuses.add(new BusDTO());

			logger.info("New bus created: {}", busDTO);
		}

		return createdBuses;
	}

}
