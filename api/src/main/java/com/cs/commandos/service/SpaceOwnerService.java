package com.cs.commandos.service;

import com.cs.commandos.model.Employee;
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

    public List<SpaceOwner> getSpaceOwners() {
        return spaceOwnerRepository.findAll();
    }

    public SpaceOwner getSpaceOwner(long id) {
        return spaceOwnerRepository.getOne(id);
    }
}
