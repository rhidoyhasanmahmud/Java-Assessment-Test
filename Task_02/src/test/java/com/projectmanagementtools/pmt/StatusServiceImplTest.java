package com.projectmanagementtools.pmt;

import com.projectmanagementtools.pmt.model.Status;
import com.projectmanagementtools.pmt.model.StatusRepo;
import com.projectmanagementtools.pmt.model.Task;
import com.projectmanagementtools.pmt.service.StatusServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class StatusServiceImplTest {

    @Mock
    private StatusRepo repo;

    @InjectMocks
    private StatusServiceImpl service;

    PageRequest pageable;
    HttpServletResponse rs = new MockHttpServletResponse();

    @Test
    public void whenSaveTask_shouldReturnTask() {
        Status status = new Status();
        status.setName("Status 1");
        status.setActive(true);
        status.setCreatedBy(1L);
        status.setCreatedByEmp("Hasan Mahmud");

        when(repo.save(ArgumentMatchers.any(Status.class))).thenReturn(status);
        Status created = service.create(status, rs);

        assertThat(created.getName()).isSameAs(status.getName());
        verify(repo).save(status);
    }

    @Test
    public void shouldReturnAllStatus() {
        List<Status> list = new ArrayList();
        list.add(new Status());

        given(repo.findAllByIsActiveOrderByIdDesc(true, pageable)).willReturn(list);

        List<Status> expected = service.getAll(true, pageable);

        assertEquals(expected, list);
        verify(repo).findAllByIsActiveOrderByIdDesc(true, pageable);
    }
}
