package com.example.accesscontrol.controller;

import com.example.accesscontrol.model.Usuario;
import com.example.accesscontrol.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    // HU002 Registrar Residente
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarResidente(@RequestBody Usuario usuario){
        Usuario u = usuarioService.registrarResidente(usuario);
        return ResponseEntity.ok(u);
    }
}
