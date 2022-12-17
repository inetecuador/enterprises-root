package com.base.service;

import java.util.List;
import com.base.common.BaseService;
import com.base.entity.EnterpriseEntity;
import com.base.repository.IEnterpriseRepository;
import com.base.util.ProjectUtil;
import com.base.vo.EnterpriseVo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EnterpriseService.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Transactional(readOnly = true)
@Lazy
@Service
public class EnterpriseService extends
    BaseService<EnterpriseEntity, IEnterpriseRepository> implements IEnterpriseService {


    /**
     * Constructor.
     *
     * @param repository IPersonRepository
     */
    public EnterpriseService(IEnterpriseRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EnterpriseVo> getAll() {
        return this.repository.getAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String name) {
        return this.repository.exist(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void create(EnterpriseVo enterprise) {
        EnterpriseEntity entity = ProjectUtil.convert(enterprise, EnterpriseEntity.class);
        this.repository.save(entity);
        enterprise.setEnterpriseId(entity.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(EnterpriseVo enterprise) {
        this.repository.updateValues(enterprise);
    }
}
