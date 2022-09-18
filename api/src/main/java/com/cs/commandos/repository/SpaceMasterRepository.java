package com.cs.commandos.repository;

import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceMasterRepository extends JpaRepository<SpaceMaster, Long> {

    List<SpaceMaster> findByIdBetween(Long startId, Long endId);
}
