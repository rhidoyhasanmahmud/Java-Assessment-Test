package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.Status;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface StatusService {
    Status create(Status ob, HttpServletResponse rs);

    List<Status> getAll(Boolean b, PageRequest of);

    Status getById(Long id);

    Status update(Status ob, HttpServletResponse rs);

    List<Map<String, Object>> getAllActiveDropdown();

    Boolean existsByName(String name);
}
