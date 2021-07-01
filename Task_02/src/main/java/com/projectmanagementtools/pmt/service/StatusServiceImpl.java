package com.projectmanagementtools.pmt.service;

import com.projectmanagementtools.pmt.model.Status;
import com.projectmanagementtools.pmt.model.StatusRepo;
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
public class StatusServiceImpl implements StatusService {
    private final StatusRepo repo;

    @Override
    public Status create(Status ob, HttpServletResponse rs) {
        try {
            return repo.save(ob);
        } catch (Exception e) {
            log.warn("Failed to create  Status: ", e);
            rs.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return ob;
        }
    }

    @Override
    public List<Status> getAll(Boolean isActive, PageRequest pageable) {
        return repo.findAllByIsActiveOrderByIdDesc(isActive, pageable).stream().peek(ob -> {
        }).collect(Collectors.toList());
    }

    @Override
    public Status getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Status update(Status ob, HttpServletResponse rs) {
        try {
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
        repo.findAllByIsActive(true).forEach(it->{
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
}
