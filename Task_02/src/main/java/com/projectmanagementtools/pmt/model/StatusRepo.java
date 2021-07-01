package com.projectmanagementtools.pmt.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepo extends JpaRepository<Status, Long> {
    Boolean existsByNameIgnoreCase(String name);
    List<Status> findAllByIsActiveOrderByIdDesc(Boolean isActive, Pageable pageable);
    List<Status> findAllByIsActive(Boolean isActive);
}
