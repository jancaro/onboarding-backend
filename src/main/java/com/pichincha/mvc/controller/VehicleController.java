package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.VehicleDto;
import com.pichincha.mvc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehiculo")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return ResponseEntity.ok(this.vehicleService.getAllVehicles());
    }

    @PostMapping("crear")
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody @Valid VehicleDto VehicleDto) {
        return ResponseEntity.ok(this.vehicleService.saveVehicle(VehicleDto));
    }

    @PutMapping("actualizar")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody @Valid VehicleDto VehicleDto) {
        return ResponseEntity.ok(this.vehicleService.updateVehicle(VehicleDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.vehicleService.getVehicleById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteVehicleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.vehicleService.deleteVehicleById(id));
    }
}
