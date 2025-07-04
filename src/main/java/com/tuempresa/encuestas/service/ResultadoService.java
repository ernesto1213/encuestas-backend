package com.tuempresa.encuestas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuempresa.encuestas.Dtos.Agregado;
import com.tuempresa.encuestas.Dtos.ResultadoPreguntaDTO;
import com.tuempresa.encuestas.model.Opcion;
import com.tuempresa.encuestas.model.Pregunta;
import com.tuempresa.encuestas.repository.OpcionRepository;
import com.tuempresa.encuestas.repository.PreguntaRepository;
import com.tuempresa.encuestas.repository.RespuestaRepository;

@Service
public class ResultadoService {

    @Autowired
    private RespuestaRepository repo;

    @Autowired
    private PreguntaRepository preguntaRepo; // para traer texto de la pregunta
    @Autowired
    private OpcionRepository opcionRepo;     // para traer texto de la opción

    public List<ResultadoPreguntaDTO> obtenerResultados(Long encuestaId) {

        var conteos = repo.contarPorPreguntaYopcion(encuestaId);

        // Agrupar por pregunta
Map<Long, List<Agregado>> porPregunta =
    conteos.stream().collect(Collectors.groupingBy(Agregado::getPreguntaId));

        List<ResultadoPreguntaDTO> lista = new ArrayList<>();

        porPregunta.forEach((pregId, agregados) -> {
            var preguntaTxt = preguntaRepo.findById(pregId).map(Pregunta::getTexto).orElse("Pregunta");
            List<String> labels = new ArrayList<>();
            List<Long> data   = new ArrayList<>();

agregados.forEach(a -> {
    var opcionTxt = opcionRepo.findById(a.getOpcionId()).map(Opcion::getTexto).orElse("Opción");
    labels.add(opcionTxt);
    data.add(a.getTotal());
});


            lista.add(new ResultadoPreguntaDTO(preguntaTxt, labels, data));
        });

        return lista;
    }
}
