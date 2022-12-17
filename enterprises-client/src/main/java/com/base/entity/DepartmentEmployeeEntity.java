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
@Entity(name = "DEPARTMENTS_EMPLOYEES")
public class DepartmentEmployeeEntity extends AbstractBaseAuditable<String> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "DEPARTMENTS_EMPLOYEES_ID")
    private String departmentEmployeeEntityId;

    @Column(name = "DEPARTMENTS_ID")
    private String departmentId;

    @Column(name = "EMPLOYEES_ID")
    private String employeesId;

    @Override
    public String getId() {
        return this.departmentEmployeeEntityId;
    }
}
