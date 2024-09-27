package com.utp.saludmaterna.service;

import com.utp.saludmaterna.persistence.dto.EventoMaternoDTO;
import com.utp.saludmaterna.persistence.entity.EventoMaterno;
import com.utp.saludmaterna.persistence.entity.Paciente;
import com.utp.saludmaterna.persistence.repository.EventoMaternoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoMaternoService {
    @Autowired
    private EntityManager entityManager;
    private EventoMaternoRepository eventoMaternoRepository;
    private Paciente paciente;

    public String registrarEvento(EventoMaternoDTO eventoMaternoDTO) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("registrarEventoMaterno");

        query.registerStoredProcedureParameter("paciente_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("tipo_evento", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("resultado_evento", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("mensaje", String.class, ParameterMode.OUT);

        query.setParameter("paciente_id", eventoMaternoDTO.getPacienteId());
        query.setParameter("tipo_evento", eventoMaternoDTO.getTipoEvento());
        query.setParameter("resultado_evento", eventoMaternoDTO.getResultadoEvento());

        query.execute();

        return (String) query.getOutputParameterValue("mensaje");
    }

}
