package com.tuempresa.encuestas.controller;

import com.tuempresa.encuestas.Dtos.RespuestaDto;
import com.tuempresa.encuestas.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/respuestas")                //  <── ESTA ES LA BASE
@CrossOrigin(origins = "http://localhost:4200")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;    //  <── Inyectado

    @PostMapping("/guardar")                      //  <── POST /api/respuestas/guardar
    public ResponseEntity<String> guardar(@RequestBody RespuestaDto dto) {
        respuestaService.guardarRespuestas(dto);
        return ResponseEntity.ok("Respuestas guardadas correctamente");
    }
}