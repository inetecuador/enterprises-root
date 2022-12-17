package com.base.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Abstract auditable.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseAuditable<PK extends Serializable> {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * True if the record is active otherwise false.
     */
    @Builder.Default
    @Column(name = "STATUS", length = 1)
    @NotNull
    protected String status = "1";

    /**
     * User who created the record.
     */
    @CreatedBy
    @NotNull
    @Column(name = "CREATED_BY", updatable = false)
    protected String createdBy;

    /**
     * Date the record was created.
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    protected Date createDate;

    /**
     * User who made the last modification of the registry.
     */
    @LastModifiedBy
    @Column(name = "MODIFIED_BY")
    protected String modifiedBy;

    /**
     * Date of the last modification.
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE")
    protected Date modifiedDate;


    public abstract PK getId();
}
