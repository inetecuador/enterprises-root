package com.base.entity;

import com.base.common.AbstractBaseAuditable;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Enterprise entity.
 *
 * @author vsangucho on 2022/12/15.
 * @version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYESS")
public class EmployeeEntity extends AbstractBaseAuditable<String> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "EMPLOYEES_ID")
    private String employeeId;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "SURNAME")
    private String surname;

    @Override
    public String getId() {
        return this.employeeId;
    }
}
