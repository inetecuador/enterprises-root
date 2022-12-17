package com.base.controller;

import java.util.List;
import javax.validation.Valid;
import com.base.service.IEnterpriseService;
import com.base.vo.EnterpriseVo;
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
@Tag(name = "Person", description = "The Persons API")
@RestController
@RequestMapping("/api/v1/enterprises")
@Lazy
public class EnterpriseController {

    @Lazy
    @Autowired
    private IEnterpriseService service;

    /**
     * Get all enterprises.
     *
     * @return list enterpriseVo
     */
    @GetMapping(path = "")
    @Operation(summary = "Get list of enterprises")
    public ResponseEntity<List<EnterpriseVo>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    /**
     * Create enterprise.
     *
     * @param request EnterpriseVo
     * @return BaseResponseVo
     */
    @PostMapping(path = "")
    @Operation(summary = "Create enterprise")
    public ResponseEntity<BaseResponseVo> create(@Valid @RequestBody EnterpriseVo request) {
        if (this.service.exist(request.getName())) {
            return ResponseEntity.ok()
                .body(BaseResponseVo.builder().code(1).build());
        }
        this.service.create(request);
        return ResponseEntity.ok(BaseResponseVo.builder().data(request).build());
    }

    /**
     * Update enterprise.
     *
     * @param request EnterpriseVo
     * @return BaseResponseVo
     */
    @PutMapping(path = "")
    @Operation(summary = "Update enterprise")
    public ResponseEntity<BaseResponseVo> update(@Valid @RequestBody EnterpriseVo request) {
        this.service.update(request);
        return ResponseEntity.ok(BaseResponseVo.builder().build());
    }


}
