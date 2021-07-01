package com.projectmanagementtools.pmt.controller;

import com.projectmanagementtools.pmt.model.Status;
import com.projectmanagementtools.pmt.service.StatusService;
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
 * {@link StatusController} Controller
 *
 * @author Hasan Mahmud
 * @since 2021-07-01
 *************************************************************************/
@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", maxAge = 3600)
public class StatusController {

    private final StatusService service;

    /*************************************************************************
     * Create a new  Status
     * @param ob {@link  Status} object
     * @param rs {@link HttpServletResponse} object
     * @return {@link  Status}
     *************************************************************************/
    @PostMapping
    public Status create(@Valid @RequestBody Status ob, HttpServletRequest rq, HttpServletResponse rs) {
        ob.setCreatedBy(Long.valueOf(rq.getHeader("createdBy")));
        ob.setCreatedByEmp(rq.getHeader("createdByEmp") + " (ID:" + rq.getHeader("createdBy") + ")");
        rs.setStatus(HttpServletResponse.SC_CREATED);
        return service.create(ob, rs);
    }

    /*************************************************************************
     * Get all active {@link  Status}
     * @param pageSize
     * @param page
     * @return {@link List < Status>}
     *************************************************************************/
    @GetMapping("/getAll/active")
    public List<Status> getAllActive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(true, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get all inactive {@link  Status}
     * @param pageSize
     * @param page
     * @return {@link List<Status>}
     *************************************************************************/
    @GetMapping("/getAll/inactive")
    public List<Status> getAllInactive(@RequestParam int page, @RequestParam int pageSize) {
        return service.getAll(false, PageRequest.of(page, pageSize));
    }

    /*************************************************************************
     * Get active {@link  Status}
     * @param id Id of a {@link  Status}
     * @return {@link  Status}
     *************************************************************************/
    @GetMapping("/get/{id}")
    public Status getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /*************************************************************************
     * Update {@link  Status}
     * @param ob {@link  Status} object
     * @return {@link  Status}
     *************************************************************************/
    @PutMapping
    public Status update(@Valid @RequestBody Status ob, HttpServletRequest rq, HttpServletResponse rs) {
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
