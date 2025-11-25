package com.example.accesscontrol.repository;

import com.example.accesscontrol.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findById(String id);
    Optional<Usuario> findByNombre(String nombre);
}
