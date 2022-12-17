package com.base.repository;

import java.util.List;
import com.base.common.IQueryDslBaseRepository;
import com.base.entity.EnterpriseEntity;
import com.base.vo.EnterpriseVo;

/**
 * IEnterpriseRepository.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
public interface IEnterpriseRepository extends IQueryDslBaseRepository<EnterpriseEntity> {

    /**
     * Get all enterprises.
     *
     * @return List EnterpriseVo
     */
    List<EnterpriseVo> getAll();

    /**
     * Verify existing enterprise.
     *
     * @param name enterprise name
     * @return Boolean
     */
    Boolean exist(String name);

    /**
     * Update enterprise.
     *
     * @param enterprise EnterpriseVo
     */
    void updateValues(EnterpriseVo enterprise);
}
