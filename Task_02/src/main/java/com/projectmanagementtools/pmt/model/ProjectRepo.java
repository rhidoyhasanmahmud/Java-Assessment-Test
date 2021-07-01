package com.projectmanagementtools.pmt.model;

import com.projectmanagementtools.pmt.service.ProjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Boolean existsByNameIgnoreCase(String name);
    List<Project> findAllByIsActiveOrderByIdDesc(Boolean isActive, Pageable pageable);
    List<Project> findAllByIsActive(Boolean isActive);
}
