package com.projectmanagementtools.pmt.controller;

import com.projectmanagementtools.pmt.model.Task;
import com.projectmanagementtools.pmt.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/*************************************************************************
 * {@link TaskController} Controller
 *
 * @author Hasan Mahmud
 * @since 2021-07-01
 *************************************************************************/
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaskController {
    private final TaskService service;

    /*************************************************************************
     * Create a new  Task
     * @param ob {@link  Task} object
     * @param rs {@link HttpServletResponse} object
     * @return {@link  Task}
     *************************************************************************/
    @PostMapping
    public Task create(@Valid @RequestBody Task ob, HttpServletRequest rq, HttpServletResponse rs) {
        ob.setCreatedBy(Long.valueOf(rq.getHeader("createdBy")));
        ob.setCreatedByEmp(rq.getHeader("createdByEmp") + " (ID:" + rq.getHeader("createdBy") + ")");
        rs.setStatus(HttpServletResponse.SC_CREATED);
        return service.create(ob, rs);
    }

    /*************************************************************************
     * Get all active {@link  Task}
     * @param pageSize
     * @param page
     * @return {@link List < Task>}
     *************************************************************************/
    @GetMapping("/getAll/active")
    public List<Task> getAllActive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(true, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get all inactive {@link  Task}
     * @param pageSize
     * @param page
     * @return {@link List<Task>}
     *************************************************************************/
    @GetMapping("/getAll/inactive")
    public List<Task> getAllInactive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(false, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get active {@link  Task}
     * @param id Id of a {@link  Task}
     * @return {@link  Task}
     *************************************************************************/
    @GetMapping("/get/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /*************************************************************************
     * Update {@link  Task}
     * @param ob {@link  Task} object
     * @return {@link  Task}
     *************************************************************************/
    @PutMapping
    public Task update(@Valid @RequestBody Task ob, HttpServletRequest rq, HttpServletResponse rs) {
        ob.setUpdatedBy(Long.valueOf(rq.getHeader("updatedBy")));
        ob.setUpdatedByEmp(rq.getHeader("updatedByEmp") + " (ID:" + rq.getHeader("updatedBy") + ")");
        return service.update(ob, rs);
    }

    /*************************************************************************
     * Check if academicQualification name already exist
     *
     * @return
     *************************************************************************/
    @GetMapping("/exists/byName")
    public Boolean existsByName(@RequestParam String name) {
        return service.existsByName(name);
    }
}
