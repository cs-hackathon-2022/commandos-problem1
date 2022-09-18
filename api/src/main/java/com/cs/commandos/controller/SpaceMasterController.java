package com.cs.commandos.controller;

import com.cs.commandos.dto.EmployeeApplicableSpaceDto;
import com.cs.commandos.model.Floor;
import com.cs.commandos.service.FloorService;
import com.cs.commandos.service.SpaceMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spaces")
public class SpaceMasterController {

	@Autowired
	private SpaceMasterService spaceMasterService;

	@GetMapping("")
	public EmployeeApplicableSpaceDto getFloors(@RequestParam Long startId, @RequestParam Long endId) {
		return spaceMasterService.getSpaceDetails(startId, endId);
	}

}
