package com.base.service;

import java.util.List;
import com.base.common.IBaseService;
import com.base.entity.DepartmentEntity;
import com.base.vo.DepartmentVo;

/**
 * Person services specification.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
public interface IDepartmentService extends IBaseService<DepartmentEntity> {


    /**
     * Get all departments.
     *
     * @return List DepartmentVo
     */
    List<DepartmentVo> getAll();

    /**
     * Verify existing department.
     *
     * @param name department name
     * @return Boolean
     */
    Boolean exist(String name);

    /**
     * Create department.
     *
     * @param department DepartmentVo
     */
    void create(DepartmentVo department);

    /**
     * Update department.
     *
     * @param request DepartmentVo
     */
    void update(DepartmentVo request);

}
