package com.example.vehiculos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.vehiculos.model.Vehiculo;

public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {

}
