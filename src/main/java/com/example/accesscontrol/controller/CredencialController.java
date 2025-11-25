package com.example.accesscontrol.controller;

import com.example.accesscontrol.model.Credencial;
import com.example.accesscontrol.service.CredencialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credenciales")
public class CredencialController {

    private final CredencialService credService;

    public CredencialController(CredencialService credService) {
        this.credService = credService;
    }

    // HU003 - Asignar Credencial
    @PostMapping("/asignar")
    public ResponseEntity<Credencial> asignar(
            @RequestParam String usuarioId,
            @RequestBody Credencial credencial) {

        Credencial creada = credService.asignarCredencial(usuarioId, credencial);
        return ResponseEntity.ok(creada);
    }

    // HU004 - Revocar / Desactivar Credencial
    @PostMapping("/revocar/{id}")
    public ResponseEntity<Credencial> revocar(@PathVariable String id) {
        Credencial revocada = credService.revocarCredencial(id);

        if (revocada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(revocada);
    }
}

