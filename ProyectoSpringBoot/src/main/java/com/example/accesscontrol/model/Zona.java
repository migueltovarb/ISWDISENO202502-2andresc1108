package com.example.accesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zona {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private int nivelSeguridad;

    public Zona() {}
    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getNivelSeguridad() { return nivelSeguridad; }
    public void setNivelSeguridad(int nivelSeguridad) { this.nivelSeguridad = nivelSeguridad; }
}
