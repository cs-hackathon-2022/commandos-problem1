package com.cs.commandos.service;

import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.repository.SpaceMasterRepository;
import com.cs.commandos.repository.SpaceOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceMasterService {

    @Autowired
    private SpaceMasterRepository spaceMasterRepository;

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
}
