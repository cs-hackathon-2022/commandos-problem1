package com.cs.commandos.service;

import com.cs.commandos.dto.FloorDto;
import com.cs.commandos.model.Employee;
import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.repository.SpaceOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceOwnerService {

    @Autowired
    private SpaceOwnerRepository spaceOwnerRepository;

    @Autowired
    private SpaceMasterService spaceMasterService;

    public List<SpaceOwner> getSpaceOwners() {
        return spaceOwnerRepository.findAll();
    }

    public SpaceOwner getSpaceOwner(Long id) {
        return spaceOwnerRepository.findByEmployeeId(id);
    }

    public  List<FloorDto> getAllocatedSpaceDetails(Long id) {
        SpaceOwner spaceOwner = getSpaceOwner(id);
        List<SpaceMaster> spaceInRange = spaceMasterService.getSpaceInRange(spaceOwner.getSeatStart(), spaceOwner.getSeatEnd());
        return spaceMasterService.getCompleteBuildingPlan(spaceInRange);
    }
}
