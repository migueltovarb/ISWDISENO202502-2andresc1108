package com.example.accesscontrol.service;

import com.example.accesscontrol.model.Usuario;
import com.example.accesscontrol.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarResidente(Usuario usuario){
        if (usuario.getId() == null || usuario.getId().isEmpty()){
            usuario.setId(UUID.randomUUID().toString());
        }
        usuario.setRol("RESIDENTE");
        return usuarioRepository.save(usuario);
    }
}
