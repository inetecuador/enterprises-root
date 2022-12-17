package com.base.repository;

import static com.base.entity.QDepartmentEntity.departmentEntity;
import static com.querydsl.core.types.Projections.bean;
import java.util.List;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.entity.DepartmentEntity;
import com.base.vo.DepartmentVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * DepartmentRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Lazy
@Repository
public class DepartmentRepository extends JPAQueryDslBaseRepository<DepartmentEntity> implements
    IDepartmentRepository {

    /**
     * Constructor.
     */
    public DepartmentRepository() {
        super(DepartmentEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DepartmentVo> getAll() {
        return from(departmentEntity)
            .select(bean(DepartmentVo.class,
                departmentEntity.departmentId,
                departmentEntity.name,
                departmentEntity.description,
                departmentEntity.phone,
                departmentEntity.createDate,
                departmentEntity.status)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String name) {
        JPQLQuery<String> query = from(departmentEntity)
            .select(departmentEntity.departmentId)
            .where(departmentEntity.name.eq(name));
        return StringUtils.isNotBlank(query.fetchFirst());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(DepartmentVo request) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(departmentEntity.departmentId.eq(request.getDepartmentId()));
        updateWithAudit(departmentEntity).where(where)
            .set(departmentEntity.name, request.getName())
            .set(departmentEntity.description, request.getDescription())
            .set(departmentEntity.phone, request.getPhone()).execute();
    }
}
