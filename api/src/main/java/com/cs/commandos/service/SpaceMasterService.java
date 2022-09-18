package com.cs.commandos.service;

import com.cs.commandos.dto.EmployeeApplicableSpaceDto;
import com.cs.commandos.dto.FloorDetails;
import com.cs.commandos.dto.SpaceMiniDto;
import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.repository.SpaceMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpaceMasterService {

    @Autowired
    private SpaceMasterRepository spaceMasterRepository;

    @Cacheable("sat")
    public List<SpaceMaster> getAllSpaces() {
        return spaceMasterRepository.findAll();
    }

    public SpaceMaster getSpaceDetails(long id) {
        return spaceMasterRepository.findById(id).get();
    }


    public boolean updateSpaceStatus(long id, String status) {
        SpaceMaster spaceMaster = spaceMasterRepository.findById(id).get();
        spaceMaster.setAvailabilityStatus(status);
        return true;
    }

    public EmployeeApplicableSpaceDto getSpaceDetails(long startSpaceId, long endSpaceId) {
        List<SpaceMaster> spaces = spaceMasterRepository.findByIdBetween(startSpaceId, endSpaceId);
        EmployeeApplicableSpaceDto employeeApplicableSpaceDto = new EmployeeApplicableSpaceDto();

        List<SpaceMiniDto> totalReservedSeats = spaces.stream().
                filter(s -> s.getAvailabilityStatus().equals("ALLOCATED")).
                map(s -> new SpaceMiniDto(s.getId(), s.getSpaceNumber())).collect(Collectors.toList());

        List<SpaceMiniDto> totalAvailableSeats = spaces.stream().
                filter(s -> s.getAvailabilityStatus().equals("AVAILABLE")).
                map(s -> new SpaceMiniDto(s.getId(), s.getSpaceNumber())).collect(Collectors.toList());

        employeeApplicableSpaceDto.setAvailableSeats(totalAvailableSeats);
        employeeApplicableSpaceDto.setReservedSeats(totalReservedSeats);

        return employeeApplicableSpaceDto;
    }

    public FloorDetails getFloorDetails() {
        List<SpaceMaster> masterSpace = getAllSpaces();
        for (SpaceMaster spaceMaster : masterSpace) {

        }

        return null;
    }
}
