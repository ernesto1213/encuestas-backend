package com.tuempresa.encuestas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuempresa.encuestas.Dtos.ResultadoPreguntaDTO;
import com.tuempresa.encuestas.service.ResultadoService;

@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "http://localhost:4200")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping("/{encuestaId}")
    public List<ResultadoPreguntaDTO> resultados(@PathVariable Long encuestaId) {
        return resultadoService.obtenerResultados(encuestaId);
    }
}