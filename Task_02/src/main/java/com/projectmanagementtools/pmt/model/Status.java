package com.projectmanagementtools.pmt.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@ToString(callSuper = true)
@Table(name = "pmt_status")
public class Status extends AbstractPersistableEntity {
    private static final long serialVersionUID = 1L;

    @Convert(converter = StringTrimConverter.class)
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;
}
