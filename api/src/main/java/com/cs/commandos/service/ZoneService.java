package com.cs.commandos.service;

import com.cs.commandos.model.Zone;
import com.cs.commandos.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    public List<Zone> getZones() {
        return zoneRepository.findAll();
    }

    public Zone getZone(long id) {
        return zoneRepository.getOne(id);
    }
}
