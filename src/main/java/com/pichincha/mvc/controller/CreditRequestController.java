package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.CreditRequestDto;
import com.pichincha.mvc.domain.enums.CreditStatus;
import com.pichincha.mvc.service.CreditRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/solicitud/credito")
public class CreditRequestController {
    private final CreditRequestService creditRequestService;

    @Autowired
    public CreditRequestController(CreditRequestService creditRequestService) {
        this.creditRequestService = creditRequestService;
    }

    @PostMapping("crear")
    public ResponseEntity<CreditRequestDto> saveCredit(@RequestBody @Valid CreditRequestDto creditRequestDto) {
        return ResponseEntity.ok(this.creditRequestService.saveCredit(creditRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<CreditRequestDto> getCredit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.creditRequestService.getCredit(id));
    }

    @PutMapping
    public ResponseEntity<CreditRequestDto> updateStatusCredit(@QueryParam("creditId") Long creditId, @QueryParam("status") CreditStatus status) {
        return ResponseEntity.ok(this.creditRequestService.updateCredit(creditId, status));
    }
}
