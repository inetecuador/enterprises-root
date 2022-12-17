package com.base.vo;

import javax.validation.constraints.NotBlank;
import com.base.vo.common.BaseAuditableVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * EnterpriseVo.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseVo extends BaseAuditableVo {

    private String enterpriseId;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    private String phone;
}
