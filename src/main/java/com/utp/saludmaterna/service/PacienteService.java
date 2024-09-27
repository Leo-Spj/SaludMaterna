package com.utp.saludmaterna.service;

import com.utp.saludmaterna.persistence.dto.PacienteDTO;
import com.utp.saludmaterna.persistence.entity.Paciente;
import com.utp.saludmaterna.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setEdad(pacienteDTO.getEdad());
        paciente.setDistrito(pacienteDTO.getDistrito());
        paciente.setHistorialMedico(pacienteDTO.getHistorialMedico());

        return pacienteRepository.save(paciente);
    }

    public Paciente obtenerPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
