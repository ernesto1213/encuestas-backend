package com.tuempresa.encuestas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuempresa.encuestas.Dtos.RespuestaDto;
import com.tuempresa.encuestas.model.Encuesta;
import com.tuempresa.encuestas.repository.EncuestaRepository;
import com.tuempresa.encuestas.service.RespuestaService;
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde Angular
@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    private final EncuestaRepository encuestaRepository;
    private RespuestaService respuestaService;

    public EncuestaController(EncuestaRepository encuestaRepository) {
        this.encuestaRepository = encuestaRepository;
    }

    @PostMapping
    public ResponseEntity<Encuesta> crearEncuesta(@RequestBody Encuesta encuesta) {System.out.println("entro?");
        Encuesta encuestaGuardada = encuestaRepository.save(encuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(encuestaGuardada);
    }

    @GetMapping
    public List<Encuesta> obtenerTodas() {
        return encuestaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encuesta> obtenerEncuestaConPreguntasYOpciones(@PathVariable Long id) {
        return encuestaRepository.findById(id)
            .map(encuesta -> ResponseEntity.ok(encuesta))
            .orElse(ResponseEntity.notFound().build());
    }

        @PostMapping("/guardar")
    public ResponseEntity<String> guardarRespuestas(@RequestBody RespuestaDto respuestas) {
        try {
            respuestaService.guardarRespuestas(respuestas);
            return ResponseEntity.ok("Respuestas guardadas correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar respuestas");
        }
    }
}
