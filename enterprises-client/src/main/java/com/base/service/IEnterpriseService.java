package com.base.service;

import java.util.List;
import com.base.common.IBaseService;
import com.base.entity.EnterpriseEntity;
import com.base.vo.EnterpriseVo;

/**
 * Person services specification.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
public interface IEnterpriseService extends IBaseService<EnterpriseEntity> {

    /**
     * Get all departments.
     *
     * @return List EnterpriseVo
     */
    List<EnterpriseVo> getAll();

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
     * @param enterprise EnterpriseVo
     */
    void create(EnterpriseVo enterprise);

    /**
     * Update enterprise.
     *
     * @param enterprise EnterpriseVo
     */
    void update(EnterpriseVo enterprise);

}
