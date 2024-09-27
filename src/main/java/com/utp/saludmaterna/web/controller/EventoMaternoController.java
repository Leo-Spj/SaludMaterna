package com.utp.saludmaterna.web.controller;

import com.utp.saludmaterna.persistence.dto.EventoMaternoDTO;
import com.utp.saludmaterna.persistence.entity.EventoMaterno;
import com.utp.saludmaterna.service.EventoMaternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoMaternoController {

    @Autowired
    private EventoMaternoService eventoMaternoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarEvento(@RequestBody EventoMaternoDTO eventoMaternoDTO) {
        String mensaje = eventoMaternoService.registrarEvento(eventoMaternoDTO);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

}
