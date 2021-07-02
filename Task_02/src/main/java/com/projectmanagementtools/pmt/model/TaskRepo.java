package com.projectmanagementtools.pmt.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Boolean existsByNameIgnoreCaseAndProject_Id(String name, Long projectId);
    List<Task> findAllByIsActiveOrderByIdDesc(Boolean isActive, Pageable pageable);
    List<Task> findAllByIsActive(Boolean isActive);
    List<Task> findAllByIsActiveAndProject(Boolean isActive, Project project);
}
