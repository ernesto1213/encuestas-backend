package com.tuempresa.encuestas.service;

import com.tuempresa.encuestas.Dtos.RespuestaDto;
import com.tuempresa.encuestas.model.Respuesta;
import com.tuempresa.encuestas.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository repo;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public void guardarRespuestas(RespuestaDto dto) {
        List<Respuesta> respuestas = dto.getRespuestas().stream().map(r -> {
            Respuesta respuesta = new Respuesta();
            respuesta.setEncuestaId(dto.getEncuestaId());
            respuesta.setPreguntaId(r.getPreguntaId());
            respuesta.setOpcionId(r.getOpcionId());
            return respuesta;
        }).collect(Collectors.toList());

        respuestaRepository.saveAll(respuestas);
    }

    
    
}
