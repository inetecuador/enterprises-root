package com.base.service;

import java.util.List;
import com.base.common.BaseService;
import com.base.entity.DepartmentEntity;
import com.base.repository.IDepartmentRepository;
import com.base.util.ProjectUtil;
import com.base.vo.DepartmentVo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DepartmentService.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Transactional(readOnly = true)
@Lazy
@Service
public class DepartmentService extends
    BaseService<DepartmentEntity, IDepartmentRepository> implements IDepartmentService {

    /**
     * Constructor.
     *
     * @param repository IPersonRepository
     */
    public DepartmentService(IDepartmentRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DepartmentVo> getAll() {
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
    public void create(DepartmentVo department) {
        DepartmentEntity entity = ProjectUtil.convert(department, DepartmentEntity.class);
        this.repository.save(entity);
        department.setDepartmentId(entity.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(DepartmentVo request) {
        this.repository.updateValues(request);
    }
}
