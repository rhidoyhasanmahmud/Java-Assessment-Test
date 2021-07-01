package com.projectmanagementtools.pmt.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Boolean existsByNameIgnoreCase(String name);
    List<Task> findAllByIsActiveOrderByIdDesc(Boolean isActive, Pageable pageable);
    List<Task> findAllByIsActive(Boolean isActive);
    List<Task> findAllByIsActiveAndProject(Boolean isActive, Project project);
}
