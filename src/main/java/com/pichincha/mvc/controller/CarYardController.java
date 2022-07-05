package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.CarYardDto;
import com.pichincha.mvc.domain.dto.ClientDto;
import com.pichincha.mvc.service.CarYardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patio")
public class CarYardController {

    private final CarYardService carYardService;

    @Autowired
    CarYardController(CarYardService carYardService) {
        this.carYardService = carYardService;
    }

    @GetMapping
    public ResponseEntity<List<CarYardDto>> getAllCarYard() {
        return ResponseEntity.ok(this.carYardService.getAllCarYard());
    }

    @PostMapping("crear")
    public ResponseEntity<CarYardDto> saveClient(@RequestBody CarYardDto carYardDto) {
        return ResponseEntity.ok(this.carYardService.saveCarYard(carYardDto));
    }

    @PutMapping("actualizar")
    public ResponseEntity<CarYardDto> updateClient(@RequestBody CarYardDto carYardDto) {
        return ResponseEntity.ok(this.carYardService.updateCarYard(carYardDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<CarYardDto> getClientByIdentification(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.carYardService.getCarYardById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.carYardService.deleteCarYard(id));
    }
}
