package com.base.controller;

import java.util.List;
import javax.validation.Valid;
import com.base.service.IEmployeeService;
import com.base.vo.EmployeeVo;
import com.base.vo.common.BaseResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
@Tag(name = "Employee", description = "The Employee API")
@RestController
@RequestMapping("/api/v1/employee")
@Lazy
public class EmployeeController {

    @Lazy
    @Autowired
    private IEmployeeService service;


    /**
     * Get all employees.
     *
     * @return list EmployeeVo
     */
    @GetMapping(path = "")
    @Operation(summary = "Get list of departments")
    public ResponseEntity<List<EmployeeVo>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    /**
     * Create employee.
     *
     * @param request DepartmentVo
     * @return BaseResponseVo
     */
    @PostMapping(path = "")
    @Operation(summary = "Create employee")
    public ResponseEntity<BaseResponseVo> create(@Valid @RequestBody EmployeeVo request) {
        if (this.service.exist(request.getName())) {
            return ResponseEntity.ok()
                .body(BaseResponseVo.builder().code(1).build());
        }
        this.service.create(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }


    /**
     * Update employee.
     *
     * @param request EmployeeVo
     * @return BaseResponseVo
     */
    @PutMapping(path = "")
    @Operation(summary = "Update employee")
    public ResponseEntity<BaseResponseVo> update(@Valid @RequestBody EmployeeVo request) {
        this.service.update(request);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }


}
