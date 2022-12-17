package com.base.vo;

import javax.validation.constraints.NotBlank;
import com.base.vo.common.BaseAuditableVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DepartmentVo.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVo extends BaseAuditableVo {

    private String departmentId;
    @NotBlank
    private String enterprisesId;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String phone;

}
