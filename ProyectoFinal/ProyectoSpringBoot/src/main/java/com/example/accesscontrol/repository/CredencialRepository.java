package com.example.accesscontrol.repository;

import com.example.accesscontrol.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, String> {}
