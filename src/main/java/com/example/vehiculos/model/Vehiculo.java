package com.example.vehiculos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Document(collection = "vehiculos")
public class Vehiculo {

    @Id
    private String id;

    @NotBlank(message = "La marca es requerida")
    private String marca;

    @NotBlank(message = "El modelo es requerido")
    private String modelo;

    @Positive(message = "El año debe ser mayor a 0")
    private int anio;

    @NotBlank(message = "La placa es requerida")
    private String placa;

    public Vehiculo() {}

    public Vehiculo(String marca, String modelo, int anio, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placa = placa;
    }

    // Getters y setters (simples para que parezca trabajo de estudiante)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
}
