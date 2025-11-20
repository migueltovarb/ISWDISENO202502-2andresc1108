package com.example.vehiculos.controller;

import com.example.vehiculos.model.Vehiculo;
import com.example.vehiculos.repository.VehiculoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository repository;

    public VehiculoController(VehiculoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo saved = repository.save(vehiculo);
        return ResponseEntity.ok(saved);
    }

    // READ - todos
    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return repository.findAll();
    }

    // READ - por id
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerPorId(@PathVariable String id) {
        Optional<Vehiculo> v = repository.findById(id);
        return v.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable String id, @Valid @RequestBody Vehiculo v) {
        Optional<Vehiculo> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Vehiculo vehiculo = opt.get();
        // Actualización simple
        vehiculo.setMarca(v.getMarca());
        vehiculo.setModelo(v.getModelo());
        vehiculo.setAnio(v.getAnio());
        vehiculo.setPlaca(v.getPlaca());
        Vehiculo updated = repository.save(vehiculo);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Vehículo eliminado: " + id);
    }
}
