package com.base.service;

import java.util.List;
import com.base.common.BaseService;
import com.base.entity.EmployeeEntity;
import com.base.repository.IEmployeeRepository;
import com.base.util.ProjectUtil;
import com.base.vo.EmployeeVo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EmployeeService.
 *
 * @author vsangucho on 16/12/2022.
 * @version 1.0
 */
@Transactional(readOnly = true)
@Lazy
@Service
public class EmployeeService extends
    BaseService<EmployeeEntity, IEmployeeRepository> implements IEmployeeService {

    /**
     * Constructor.
     *
     * @param repository IEmployeeRepository
     */
    public EmployeeService(IEmployeeRepository repository) {
        super(repository);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeVo> getAll() {
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
    public void create(EmployeeVo employeeVo) {
        EmployeeEntity entity = ProjectUtil.convert(employeeVo, EmployeeEntity.class);
        this.repository.save(entity);
        employeeVo.setEmployeeId(entity.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(EmployeeVo request) {
        this.repository.updateValues(request);
    }
}
