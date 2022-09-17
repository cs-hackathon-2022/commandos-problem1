package com.cs.commandos.repository;

import com.cs.commandos.model.Floor;
import com.cs.commandos.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
}
