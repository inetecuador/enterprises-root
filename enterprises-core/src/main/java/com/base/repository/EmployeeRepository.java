package com.base.repository;

import static com.base.entity.QEmployeeEntity.employeeEntity;
import static com.querydsl.core.types.Projections.bean;
import java.util.List;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.entity.EmployeeEntity;
import com.base.vo.EmployeeVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Lazy
@Repository
public class EmployeeRepository extends JPAQueryDslBaseRepository<EmployeeEntity> implements
    IEmployeeRepository {


    /**
     * Constructor.
     */
    public EmployeeRepository() {
        super(EmployeeEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeVo> getAll() {
        return from(employeeEntity)
            .select(bean(EmployeeVo.class,
                employeeEntity.employeeId,
                employeeEntity.age,
                employeeEntity.email,
                employeeEntity.name,
                employeeEntity.position,
                employeeEntity.surname,
                employeeEntity.createDate,
                employeeEntity.status)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String name) {
        JPQLQuery<String> query = from(employeeEntity)
            .select(employeeEntity.employeeId)
            .where(employeeEntity.name.eq(name));
        return StringUtils.isNotBlank(query.fetchFirst());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(EmployeeVo request) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(employeeEntity.employeeId.eq(request.getEmployeeId()));
        updateWithAudit(employeeEntity).where(where)
            .set(employeeEntity.name, request.getName())
            .set(employeeEntity.age, request.getAge())
            .set(employeeEntity.position, request.getPosition())
            .set(employeeEntity.surname, request.getSurname())
            .set(employeeEntity.email, request.getEmail()).execute();
    }
}
