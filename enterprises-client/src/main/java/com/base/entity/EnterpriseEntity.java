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
@Entity(name = "ENTERPRISES")
public class EnterpriseEntity extends AbstractBaseAuditable<String> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ENTERPRISES_ID")
    private String enterpriseId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Override
    public String getId() {
        return this.enterpriseId;
    }
}
