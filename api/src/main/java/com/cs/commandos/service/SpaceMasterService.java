package com.cs.commandos.service;

import com.cs.commandos.dto.*;
import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.repository.SpaceMasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public List<FloorDto> getCompleteBuildingPlan() {
        List<SpaceMaster> masterSpace = getAllSpaces();

        Map<String, List<SpaceMaster>> floorPlan = masterSpace.parallelStream().collect(Collectors.groupingBy(SpaceMaster::getFloor));

        List<FloorDto> floorDtoList = new LinkedList<>();

        for(Map.Entry<String, List<SpaceMaster>> entry : floorPlan.entrySet()) {

            int floorSeatCount = 0;
            boolean isFloorAvailable = false;

            FloorDto floorDto = new FloorDto();

            Map<String, List<SpaceMaster>> zonePlan = entry.getValue().parallelStream().collect(Collectors.groupingBy(SpaceMaster::getZone));

            List<ZoneDto> zoneDtoList = new LinkedList<>();

            for(Map.Entry<String, List<SpaceMaster>> zoneDetails : zonePlan.entrySet()) {

                ZoneDto zoneDto = new ZoneDto();

                    List<SpaceMaster> spaceMasterList = zoneDetails.getValue();
                    zoneDto.setZoneName(zoneDetails.getKey());
                    zoneDto.setNumberOfSeats(spaceMasterList.size());

                    List<SpaceMiniDto> totalReservedSeats = spaceMasterList.stream().
                            filter(s -> s.getAvailabilityStatus().equals("ALLOCATED")).
                            map(s -> new SpaceMiniDto(s.getId(), s.getSpaceNumber())).collect(Collectors.toList());

                    List<SpaceMiniDto> totalAvailableSeats = spaceMasterList.stream().
                            filter(s -> s.getAvailabilityStatus().equals("AVAILABLE")).
                            map(s -> new SpaceMiniDto(s.getId(), s.getSpaceNumber())).collect(Collectors.toList());

                    if(totalAvailableSeats.size() >= 1 && isFloorAvailable == false) {
                        isFloorAvailable = true;
                    }

                    zoneDto.setAvailableSeatCount(totalAvailableSeats.size());
                    zoneDto.setAvailableSeats(totalAvailableSeats);
                    zoneDto.setReservedSeats(totalReservedSeats);
                    zoneDto.setReservedSeatCount(totalReservedSeats.size());
                    zoneDtoList.add(zoneDto);
                    floorSeatCount += totalReservedSeats.size() + totalAvailableSeats.size();
            }

            floorDto.setZoneDtoList(zoneDtoList);
            floorDto.setFloorName(entry.getKey());
            floorDto.setCount(floorSeatCount); //?
            floorDto.setIsAvailable(isFloorAvailable); //?
            floorDtoList.add(floorDto);
        }

        return floorDtoList;
    }
}
