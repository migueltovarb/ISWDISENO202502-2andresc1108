package com.example.accesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Credencial {
    @Id
    private String id;
    private String tipo;
    private boolean activa;
    private LocalDate fechaActivacion;

    public Credencial() {}

    public Credencial(String id, String tipo, boolean activa) {
        this.id = id;
        this.tipo = tipo;
        this.activa = activa;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public LocalDate getFechaActivacion() { return fechaActivacion; }
    public void setFechaActivacion(LocalDate fechaActivacion) { this.fechaActivacion = fechaActivacion; }
}
