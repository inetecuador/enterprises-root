package com.base.controller;

import java.util.List;
import javax.validation.Valid;
import com.base.service.IDepartmentService;
import com.base.vo.DepartmentVo;
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
@Tag(name = "Department", description = "The department API")
@RestController
@RequestMapping("/api/v1/department")
@Lazy
public class DepartmentController {

    @Lazy
    @Autowired
    private IDepartmentService service;


    /**
     * Get all departments.
     *
     * @return list personVo
     */
    @GetMapping(path = "")
    @Operation(summary = "Get list of departments")
    public ResponseEntity<List<DepartmentVo>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    /**
     * Create department.
     *
     * @param request DepartmentVo
     * @return BaseResponseVo
     */
    @PostMapping(path = "")
    @Operation(summary = "Create department")
    public ResponseEntity<BaseResponseVo> create(@Valid @RequestBody DepartmentVo request) {
        if (this.service.exist(request.getName())) {
            return ResponseEntity.ok()
                .body(BaseResponseVo.builder().code(1).build());
        }
        this.service.create(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }


    /**
     * Update department.
     *
     * @param request DepartmentVo
     * @return BaseResponseVo
     */
    @PutMapping(path = "")
    @Operation(summary = "Update department")
    public ResponseEntity<BaseResponseVo> update(@Valid @RequestBody DepartmentVo request) {
        this.service.update(request);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }


}
