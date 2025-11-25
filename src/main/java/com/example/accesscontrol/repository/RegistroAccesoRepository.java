package com.example.accesscontrol.repository;

import com.example.accesscontrol.model.RegistroAcceso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroAccesoRepository extends MongoRepository<RegistroAcceso, String> {}
