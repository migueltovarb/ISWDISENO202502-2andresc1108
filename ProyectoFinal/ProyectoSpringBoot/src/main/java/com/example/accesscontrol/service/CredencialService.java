package com.example.accesscontrol.service;

import com.example.accesscontrol.model.Credencial;
import com.example.accesscontrol.model.Usuario;
import com.example.accesscontrol.repository.CredencialRepository;
import com.example.accesscontrol.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CredencialService {
    private final CredencialRepository credRepo;
    private final UsuarioRepository usuarioRepo;

    public CredencialService(CredencialRepository credRepo, UsuarioRepository usuarioRepo){
        this.credRepo = credRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public Credencial asignarCredencial(String usuarioId, Credencial credencial){
        // create and activate credential, link logic is simplified to just save credential
        credencial.setActiva(true);
        credencial.setFechaActivacion(LocalDate.now());
        return credRepo.save(credencial);
    }

    public Credencial revocarCredencial(String credId){
        return credRepo.findById(credId).map(c -> {
            c.setActiva(false);
            return credRepo.save(c);
        }).orElse(null);
    }
}
