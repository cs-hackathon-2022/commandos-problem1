package com.cs.commandos.controller;

import com.cs.commandos.dto.FloorDto;
import com.cs.commandos.model.Employee;
import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.model.User;
import com.cs.commandos.repository.SpaceOwnerRepository;
import com.cs.commandos.service.SpaceOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class SpaceOwnerController {
    @Autowired
    private SpaceOwnerService spaceOwnerService;

    @GetMapping("/space-owner")
    public List<SpaceOwner> getSpaceOwners() {
        return spaceOwnerService.getSpaceOwners();
    }

    @GetMapping(path = { "/space-owner/{id}" })
    public SpaceOwner getSpaceOwner(@PathVariable("id") Long id) {
        SpaceOwner spaceOwner = spaceOwnerService.getSpaceOwner(id);
        return spaceOwner;
    }

    @GetMapping(path = { "/space-owner/{id}/allocatedSpaces" })
    public List<FloorDto> getAllocatedSpaces(@PathVariable("id") Long id) {
        return spaceOwnerService.getAllocatedSpaceDetails(id);
    }
}
