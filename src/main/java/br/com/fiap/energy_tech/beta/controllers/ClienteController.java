package br.com.fiap.energy_tech.beta.controllers;

import br.com.fiap.energy_tech.beta.entities.Cliente;
import br.com.fiap.energy_tech.beta.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

        @GetMapping
        public ResponseEntity<Collection<Cliente>> findAll() {
            var cliente = service.findAll();
            return ResponseEntity.ok(cliente);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Optional<Cliente>> findById(@PathVariable UUID id) {
            var cliente = service.findById(id);
            return ResponseEntity.ok(cliente);
        }

        @PostMapping
        public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
            cliente = service.save(cliente);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(cliente);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cliente> update(@PathVariable UUID id, @RequestBody Cliente cliente) {

            cliente = service.update(id, cliente);
            return ResponseEntity.ok(cliente);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable UUID id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

}
