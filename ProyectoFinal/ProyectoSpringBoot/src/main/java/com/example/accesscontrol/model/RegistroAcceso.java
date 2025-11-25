package com.example.accesscontrol.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "registro_acceso")
public class RegistroAcceso {
    @Id
    private String id;
    private LocalDateTime fechaHora;
    private boolean exitoso;
    private String motivo;
    private String usuarioId;
    private String puertaId;

    public RegistroAcceso() {}

    public RegistroAcceso(LocalDateTime fechaHora, boolean exitoso, String motivo, String usuarioId, String puertaId) {
        this.fechaHora = fechaHora;
        this.exitoso = exitoso;
        this.motivo = motivo;
        this.usuarioId = usuarioId;
        this.puertaId = puertaId;
    }

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public boolean isExitoso() { return exitoso; }
    public void setExitoso(boolean exitoso) { this.exitoso = exitoso; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getPuertaId() { return puertaId; }
    public void setPuertaId(String puertaId) { this.puertaId = puertaId; }
}
