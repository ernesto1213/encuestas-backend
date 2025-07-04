package com.tuempresa.encuestas.Dtos;

// src/main/java/com/tuempresa/encuestas/dto/Agregado.java


/** DTO para devolver conteos de respuestas por pregunta y opción */
public class Agregado {

    private Long preguntaId;
    private Long opcionId;
    private Long total;

    public Agregado(Long preguntaId, Long opcionId, Long total) {
        this.preguntaId = preguntaId;
        this.opcionId   = opcionId;
        this.total      = total;
    }

    public Long getPreguntaId() { return preguntaId; }
    public Long getOpcionId()   { return opcionId;   }
    public Long getTotal()      { return total;      }
}
