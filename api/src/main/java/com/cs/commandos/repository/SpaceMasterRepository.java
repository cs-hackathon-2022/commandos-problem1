package com.cs.commandos.repository;

import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceMasterRepository extends JpaRepository<SpaceMaster, Long> {
}
