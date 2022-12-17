package com.base.service;

import java.util.List;
import com.base.common.IBaseService;
import com.base.entity.EmployeeEntity;
import com.base.vo.EmployeeVo;

/**
 * Person services specification.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
public interface IEmployeeService extends IBaseService<EmployeeEntity> {

    /**
     * Get all departments.
     *
     * @return List EmployeeVo
     */
    List<EmployeeVo> getAll();

    /**
     * Verify existing department.
     *
     * @param name department name
     * @return Boolean
     */
    Boolean exist(String name);

    /**
     * Create enterprise.
     *
     * @param request EmployeeVo
     */
    void create(EmployeeVo request);

    /**
     * Update employee.
     *
     * @param request EmployeeVo
     */
    void update(EmployeeVo request);
}
