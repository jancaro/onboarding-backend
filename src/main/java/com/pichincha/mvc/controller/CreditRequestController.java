package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.CreditRequestDto;
import com.pichincha.mvc.service.CreditRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud/credito")
public class CreditRequestController {
    private final CreditRequestService creditRequestService;

    @Autowired
    public CreditRequestController(CreditRequestService creditRequestService) {
        this.creditRequestService = creditRequestService;
    }

    @PostMapping("crear")
    public ResponseEntity<CreditRequestDto> saveCredit(@RequestBody CreditRequestDto creditRequestDto) {
        return ResponseEntity.ok(this.creditRequestService.saveCredit(creditRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<CreditRequestDto> getCredit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.creditRequestService.getCredit(id));
    }
}
