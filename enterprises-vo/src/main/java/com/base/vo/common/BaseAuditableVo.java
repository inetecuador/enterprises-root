package com.base.vo.common;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * BaseAuditableVO.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 * @since 1.0.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseAuditableVo {

    private String status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

}
