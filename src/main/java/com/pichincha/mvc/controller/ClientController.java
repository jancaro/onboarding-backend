package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.ClientDto;
import com.pichincha.mvc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(this.clientService.getAll());
    }

    @PostMapping("crear")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(this.clientService.saveClient(clientDto));
    }

    @PutMapping("actualizar")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(this.clientService.updateClient(clientDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientByIdentification(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.clientService.getClient(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.clientService.deleteClient(id));
    }
}
