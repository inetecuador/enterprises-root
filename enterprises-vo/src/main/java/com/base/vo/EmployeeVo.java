package com.base.vo;

import com.base.vo.common.BaseAuditableVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * EmployeeVo.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVo extends BaseAuditableVo {

    private String employeeId;
    private Integer age;
    private String email;
    private String name;
    private String position;
    private String surname;
}
