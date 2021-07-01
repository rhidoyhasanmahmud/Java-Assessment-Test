package com.projectmanagementtools.pmt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@ToString(callSuper = true)
@Table(name = "pmt_project")
public class Project extends AbstractPersistableEntity {
    private static final long serialVersionUID = 1L;

    @Convert(converter = StringTrimConverter.class)
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Status status;

    @Transient
    private Long statusId;

    @Transient
    private String statusName;

    @Transient
    List<Task> taskList = new ArrayList<>();
}
