package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.Task;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TaskService {
    Task create(Task ob, HttpServletResponse rs);

    List<Task> getAll(Boolean b, PageRequest of);

    Task getById(Long id);

    Task update(Task ob, HttpServletResponse rs);

    Boolean existsByName(String name, Long projectId);
}
