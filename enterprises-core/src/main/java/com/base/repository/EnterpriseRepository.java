package com.base.repository;

import static com.base.entity.QEnterpriseEntity.enterpriseEntity;
import static com.querydsl.core.types.Projections.bean;
import java.util.List;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.entity.EnterpriseEntity;
import com.base.vo.EnterpriseVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * EnterpriseRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Lazy
@Repository
public class EnterpriseRepository extends JPAQueryDslBaseRepository<EnterpriseEntity> implements
    IEnterpriseRepository {

    /**
     * Constructor.
     */
    public EnterpriseRepository() {
        super(EnterpriseEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnterpriseVo> getAll() {
        return from(enterpriseEntity)
            .select(bean(EnterpriseVo.class,
                enterpriseEntity.enterpriseId,
                enterpriseEntity.name,
                enterpriseEntity.address,
                enterpriseEntity.phone,
                enterpriseEntity.createDate,
                enterpriseEntity.status)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String name) {
        JPQLQuery<String> query = from(enterpriseEntity)
            .select(enterpriseEntity.enterpriseId)
            .where(enterpriseEntity.name.eq(name));
        return StringUtils.isNotBlank(query.fetchFirst());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(EnterpriseVo enterprise) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(enterpriseEntity.enterpriseId.eq(enterprise.getEnterpriseId()));
        updateWithAudit(enterpriseEntity).where(where)
            .set(enterpriseEntity.name, enterprise.getName())
            .set(enterpriseEntity.address, enterprise.getAddress())
            .set(enterpriseEntity.phone, enterprise.getPhone()).execute();
    }
}
