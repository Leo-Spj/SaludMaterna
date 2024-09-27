package com.utp.saludmaterna.persistence.dto;

public class EventoMaternoDTO {
    private Long pacienteId;
    private String tipoEvento;
    private String resultadoEvento;

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getResultadoEvento() {
        return resultadoEvento;
    }

    public void setResultadoEvento(String resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }
}
