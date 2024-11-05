package br.com.fiap.energy_tech.beta.controllers;

import br.com.fiap.energy_tech.beta.entities.Eletrodomestico;
import br.com.fiap.energy_tech.beta.services.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Eletrodomesticos")
public class EletrodomesticoController {

    @Autowired
    private EletrodomesticoService service;

    @GetMapping
    public ResponseEntity<Collection<Eletrodomestico>> findAll() {
        var eletrodomesticos = service.findAll();
        return ResponseEntity.ok(eletrodomesticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Eletrodomestico>> findById(@PathVariable UUID id) {
        var eletrodomestico = service.findById(id);
        return ResponseEntity.ok(eletrodomestico);
    }

    @PostMapping
    public ResponseEntity<Eletrodomestico> save(@RequestBody Eletrodomestico eletrodomestico) {
        eletrodomestico = service.save(eletrodomestico);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(eletrodomestico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eletrodomestico> update(@PathVariable UUID id, @RequestBody Eletrodomestico eletrodomestico) {

        eletrodomestico = service.update(id, eletrodomestico);
        return ResponseEntity.ok(eletrodomestico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
