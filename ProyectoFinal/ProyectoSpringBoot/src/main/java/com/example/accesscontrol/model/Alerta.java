package com.example.accesscontrol.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "alertas")
public class Alerta {
    @Id
    private String id;
    private String tipo;
    private String mensaje;
    private LocalDateTime fechaHora;
    private boolean critica;

    public Alerta() {}
    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public boolean isCritica() { return critica; }
    public void setCritica(boolean critica) { this.critica = critica; }
}
