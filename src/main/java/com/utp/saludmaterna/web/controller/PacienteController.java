package com.utp.saludmaterna.web.controller;

import com.utp.saludmaterna.persistence.dto.PacienteDTO;
import com.utp.saludmaterna.persistence.entity.Paciente;
import com.utp.saludmaterna.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente nuevaPaciente = pacienteService.crearPaciente(pacienteDTO);
        return new ResponseEntity<>(nuevaPaciente, HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Paciente> obtenerPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.obtenerPaciente(id);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>("Paciente eliminado", HttpStatus.OK);
    }
}
