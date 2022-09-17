package com.cs.commandos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.commandos.model.Floor;
import com.cs.commandos.repository.FloorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> getFloors() {
        return floorRepository.findAll();
    }

  
}
