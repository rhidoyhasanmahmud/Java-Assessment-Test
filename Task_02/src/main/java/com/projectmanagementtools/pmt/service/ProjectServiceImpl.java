package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepo repo;
    private final StatusRepo statusRepo;
    private final TaskRepo taskRepo;

    @Override
    public Project create(Project ob, HttpServletResponse rs) {
        try {
            ob.setStatus(statusRepo.findById(ob.getStatusId()).get());
            return repo.save(ob);
        } catch (Exception e) {
            log.warn("Failed to create  Project: ", e);
            rs.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ob;
        }
    }

    @Override
    public List<Project> getAll(Boolean isActive, PageRequest pageable) {
        return repo.findAllByIsActiveOrderByIdDesc(isActive, pageable).stream().peek(ob -> {
            setIdAndNameInObjectVal(ob);
        }).collect(Collectors.toList());
    }

    @Override
    public Project getById(Long id) {
        Project ob = repo.findById(id).get();
        return setIdAndNameInObjectVal(ob);
    }

    @Override
    public Project update(Project ob, HttpServletResponse rs) {
        try {
            ob.setStatus(statusRepo.findById(ob.getStatusId()).get());
            return repo.save(ob);
        } catch (Exception e) {
            log.warn("Failed to update  AcademicQualification: ", e);
            rs.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ob;
        }
    }

    @Override
    public List<Map<String, Object>> getAllActiveDropdown() {
        List<Map<String, Object>> list = new ArrayList<>();
        repo.findAllByIsActive(true).forEach(it -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", it.getName());
            map.put("id", it.getId());
            list.add(map);
        });
        return list;
    }

    @Override
    public Boolean existsByName(String name) {
        return repo.existsByNameIgnoreCase(name);
    }

    private Project setIdAndNameInObjectVal(Project ob) {
        ob.setStatusId(ob.getStatus().getId());
        ob.setStatusName(ob.getStatus().getName());
        List<Task> taskList = taskRepo.findAllByIsActiveAndProject(true, ob).stream().peek(task -> {
            setIdAndNameInTaskObjectVal(task);
        }).collect(Collectors.toList());
        ob.setTaskList(taskList);
        return ob;
    }

    private Task setIdAndNameInTaskObjectVal(Task ob) {
        ob.setStatusId(ob.getStatus().getId());
        ob.setStatusName(ob.getStatus().getName());
        ob.setProjectId(ob.getProject().getId());
        ob.setProjectName(ob.getProject().getName());
        return ob;
    }
}
