package com.cs.commandos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.commandos.model.Floor;
import com.cs.commandos.service.FloorService;

@RestController
public class FloorController {

	@Autowired
	private FloorService floorService;

	@GetMapping("/floors")
	public List<Floor> getFloors() {
		return floorService.getFloors();
	}

}
