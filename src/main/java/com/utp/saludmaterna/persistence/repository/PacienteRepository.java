package com.utp.saludmaterna.persistence.repository;

import com.utp.saludmaterna.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
