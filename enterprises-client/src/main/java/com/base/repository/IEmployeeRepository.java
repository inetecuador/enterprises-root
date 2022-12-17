package com.base.repository;

import java.util.List;
import com.base.common.IQueryDslBaseRepository;
import com.base.entity.EmployeeEntity;
import com.base.vo.EmployeeVo;

/**
 * IEmployeeRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
public interface IEmployeeRepository extends IQueryDslBaseRepository<EmployeeEntity> {

    /**
     * Get all employees.
     *
     * @return List EmployeeVo
     */
    List<EmployeeVo> getAll();

    /**
     * Verify existing employee.
     *
     * @param name employee name
     * @return Boolean
     */
    Boolean exist(String name);

    /**
     * Update employee.
     *
     * @param request EmployeeVo
     */
    void updateValues(EmployeeVo request);
}
