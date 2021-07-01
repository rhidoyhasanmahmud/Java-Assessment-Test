package com.projectmanagementtools.pmt.controller;

import com.projectmanagementtools.pmt.model.Project;
import com.projectmanagementtools.pmt.service.ProjectService;
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
 * {@link ProjectController} Controller
 *
 * @author Hasan Mahmud
 * @since 2021-07-01
 *************************************************************************/
@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectController {
    private final ProjectService service;

    /*************************************************************************
     * Create a new  Project
     * @param ob {@link  Project} object
     * @param rs {@link HttpServletResponse} object
     * @return {@link  Project}
     *************************************************************************/
    @PostMapping
    public Project create(@Valid @RequestBody Project ob, HttpServletRequest rq, HttpServletResponse rs) {
        ob.setCreatedBy(Long.valueOf(rq.getHeader("createdBy")));
        ob.setCreatedByEmp(rq.getHeader("createdByEmp") + " (ID:" + rq.getHeader("createdBy") + ")");
        rs.setStatus(HttpServletResponse.SC_CREATED);
        return service.create(ob, rs);
    }

    /*************************************************************************
     * Get all active {@link  Project}
     * @param pageSize
     * @param page
     * @return {@link List < Project>}
     *************************************************************************/
    @GetMapping("/getAll/active")
    public List<Project> getAllActive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(true, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get all inactive {@link  Project}
     * @param pageSize
     * @param page
     * @return {@link List<Project>}
     *************************************************************************/
    @GetMapping("/getAll/inactive")
    public List<Project> getAllInactive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(false, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get active {@link  Project}
     * @param id Id of a {@link  Project}
     * @return {@link  Project}
     *************************************************************************/
    @GetMapping("/get/{id}")
    public Project getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /*************************************************************************
     * Update {@link  Project}
     * @param ob {@link  Project} object
     * @return {@link  Project}
     *************************************************************************/
    @PutMapping
    public Project update(@Valid @RequestBody Project ob, HttpServletRequest rq, HttpServletResponse rs) {
        ob.setUpdatedBy(Long.valueOf(rq.getHeader("updatedBy")));
        ob.setUpdatedByEmp(rq.getHeader("updatedByEmp") + " (ID:" + rq.getHeader("updatedBy") + ")");
        return service.update(ob, rs);
    }

    /*************************************************************************
     * Get All active dropdown data
     * @return
     *************************************************************************/
    @GetMapping("getAll/active/dropdown")
    public List<Map<String, Object>> getAllActiveDropdown() {
        return service.getAllActiveDropdown();
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
