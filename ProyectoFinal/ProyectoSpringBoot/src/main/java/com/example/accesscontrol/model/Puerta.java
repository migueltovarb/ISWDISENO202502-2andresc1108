package com.example.accesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Puerta {
    @Id
    private String id;
    private String nombre;
    private boolean estadoBloqueo;

    public Puerta() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public boolean isEstadoBloqueo() { return estadoBloqueo; }
    public void setEstadoBloqueo(boolean estadoBloqueo) { this.estadoBloqueo = estadoBloqueo; }
}
