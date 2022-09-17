package com.cs.commandos.service;

import com.cs.commandos.model.Zone;
import com.cs.commandos.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    public List<Zone> getZones() {
        List<Zone> findAll = zoneRepository.findAll();
		return findAll;
    }

    public Zone getZone(long id) {
        return Optional.of(zoneRepository.findById(id)).get().orElse(null);
    }
}
