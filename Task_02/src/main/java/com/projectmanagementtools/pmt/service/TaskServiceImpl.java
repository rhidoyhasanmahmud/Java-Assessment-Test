package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.ProjectRepo;
import com.projectmanagementtools.pmt.model.Task;
import com.projectmanagementtools.pmt.model.TaskRepo;
import com.projectmanagementtools.pmt.model.StatusRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepo repo;
    private final StatusRepo statusRepo;
    private final ProjectRepo projectRepo;

    @Override
    public Task create(Task ob, HttpServletResponse rs) {
        try {
            ob.setStatus(statusRepo.findById(ob.getStatusId()).get());
            ob.setProject(projectRepo.findById(ob.getProjectId()).get());
            return repo.save(ob);
        } catch (Exception e) {
            log.warn("Failed to create  Task: ", e);
            rs.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ob;
        }
    }

    @Override
    public List<Task> getAll(Boolean isActive, PageRequest pageable) {
        return repo.findAllByIsActiveOrderByIdDesc(isActive, pageable).stream().peek(ob -> {
            setIdAndNameInObjectVal(ob);
        }).collect(Collectors.toList());
    }

    @Override
    public Task getById(Long id) {
        Task ob = repo.findById(id).get();
        return setIdAndNameInObjectVal(ob);
    }

    @Override
    public Task update(Task ob, HttpServletResponse rs) {
        try {
            ob.setStatus(statusRepo.findById(ob.getStatusId()).get());
            ob.setProject(projectRepo.findById(ob.getProjectId()).get());
            return repo.save(ob);
        } catch (Exception e) {
            log.warn("Failed to update  AcademicQualification: ", e);
            rs.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ob;
        }
    }

    @Override
    public Boolean existsByName(String name, Long projectId) {
        System.out.println("OK" + projectId);
        return repo.existsByNameIgnoreCaseAndProject_Id(name, projectId);
    }

    private Task setIdAndNameInObjectVal(Task ob) {
        ob.setStatusId(ob.getStatus().getId());
        ob.setStatusName(ob.getStatus().getName());
        ob.setProjectId(ob.getProject().getId());
        ob.setProjectName(ob.getProject().getName());
        return ob;
    }
}