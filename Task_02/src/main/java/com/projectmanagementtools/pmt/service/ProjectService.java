package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.Project;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface ProjectService {
    Project create(Project ob, HttpServletResponse rs);

    List<Project> getAll(Boolean b, PageRequest of);

    Project getById(Long id);

    Project update(Project ob, HttpServletResponse rs);

    List<Map<String, Object>> getAllActiveDropdown();

    Boolean existsByName(String name);
}
