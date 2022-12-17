package com.base.repository;

import java.util.List;
import com.base.common.IQueryDslBaseRepository;
import com.base.entity.DepartmentEntity;
import com.base.vo.DepartmentVo;

/**
 * IDepartmentRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
public interface IDepartmentRepository extends IQueryDslBaseRepository<DepartmentEntity> {


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
     * Update department.
     *
     * @param request DepartmentVo
     */
    void updateValues(DepartmentVo request);

}
