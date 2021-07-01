package com.projectmanagementtools.pmt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@ToString(callSuper = true)
@Table(name = "pmt_task")
public class Task extends AbstractPersistableEntity {
    private static final long serialVersionUID = 1L;

    @Convert(converter = StringTrimConverter.class)
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Project project;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Status status;

    @Transient
    private Long statusId;

    @Transient
    private String statusName;

    @Transient
    private Long projectId;

    @Transient
    private String projectName;
}
