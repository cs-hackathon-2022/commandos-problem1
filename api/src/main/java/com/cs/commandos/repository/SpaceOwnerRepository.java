package com.cs.commandos.repository;

import com.cs.commandos.model.SpaceOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceOwnerRepository extends JpaRepository<SpaceOwner, Long> {

    public SpaceOwner findByEmployeeId(int employeeId);
}
