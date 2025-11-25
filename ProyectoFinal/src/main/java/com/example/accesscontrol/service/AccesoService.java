package com.example.accesscontrol.service;

import com.example.accesscontrol.model.RegistroAcceso;
import com.example.accesscontrol.repository.RegistroAccesoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccesoService {
    private final RegistroAccesoRepository registroRepo;

    public AccesoService(RegistroAccesoRepository registroRepo){
        this.registroRepo = registroRepo;
    }

    public RegistroAcceso registrarIntento(String usuarioId, String puertaId, boolean exitoso, String motivo){
        RegistroAcceso r = new RegistroAcceso(LocalDateTime.now(), exitoso, motivo, usuarioId, puertaId);
        return registroRepo.save(r);
    }
}
