package com.cs.commandos.controller;

import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.model.Zone;
import com.cs.commandos.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping("/space-owner")
    public List<Zone> getZones() {
        return zoneService.getZones();
    }

    @GetMapping(path = { "/space-owner/{id}" })
    public Zone getZone(@PathVariable("id") long id) {
        Zone zone = zoneService.getZone(id);
        return zone;
    }
}
