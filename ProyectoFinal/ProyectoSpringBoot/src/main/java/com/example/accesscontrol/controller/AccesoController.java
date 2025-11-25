package com.example.accesscontrol.controller;

import com.example.accesscontrol.model.RegistroAcceso;
import com.example.accesscontrol.service.AccesoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accesos")
public class AccesoController {
    private final AccesoService accesoService;
    public AccesoController(AccesoService accesoService){ this.accesoService = accesoService; }

    // HU201 Registro de Intento de Acceso
    @PostMapping("/registrar")
    public ResponseEntity<RegistroAcceso> registrarIntento(@RequestParam String usuarioId,
                                                           @RequestParam String puertaId,
                                                           @RequestParam boolean exitoso,
                                                           @RequestParam(required=false) String motivo){
        RegistroAcceso r = accesoService.registrarIntento(usuarioId, puertaId, exitoso, motivo);
        return ResponseEntity.ok(r);
    }
}
