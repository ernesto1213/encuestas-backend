package com.tuempresa.encuestas.Dtos;

import java.util.List;

public record ResultadoPreguntaDTO(
        String pregunta,
        List<String> labels,
        List<Long> data) {}
