package com.example.accesscontrol.repository;

import com.example.accesscontrol.model.Alerta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertaRepository extends MongoRepository<Alerta, String> {}
