package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.AssignClientToCarYardDto;
import com.pichincha.mvc.service.AssignClientToCarYardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.Map;

@RestController
@RequestMapping("/asignacion/cliente/patio")
public class AssignClientToCarYardController {
    private final AssignClientToCarYardService service;

    @Autowired
    AssignClientToCarYardController(AssignClientToCarYardService service) {
        this.service = service;
    }

    @PostMapping("crear")
    public ResponseEntity<AssignClientToCarYardDto> saveAssign(@RequestBody @Valid AssignClientToCarYardDto assignDto) {
        return ResponseEntity.ok(this.service.saveAssignDto(assignDto));
    }

    @PutMapping("actualizar")
    public ResponseEntity<AssignClientToCarYardDto> updateAssign(@RequestBody @Valid AssignClientToCarYardDto assignDto) {
        return ResponseEntity.ok(this.service.updateAssign(assignDto));
    }

    @GetMapping
    public ResponseEntity<AssignClientToCarYardDto> getAssign(@QueryParam("clientId") Long clientId, @QueryParam("carYardId")  Long carYardId) {
        return ResponseEntity.ok(this.service.getAssign(clientId, carYardId));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteAssign(@QueryParam("clientId") Long clientId, @QueryParam("carYardId")  Long carYardId) {
        return ResponseEntity.ok(this.service.deleteAssign(clientId, carYardId));
    }
}
