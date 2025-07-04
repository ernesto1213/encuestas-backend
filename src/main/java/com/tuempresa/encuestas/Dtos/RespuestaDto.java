package com.tuempresa.encuestas.Dtos;

import java.util.List;

public class RespuestaDto {

    private Long encuestaId;
    private List<RespuestaPreguntaDTO> respuestas;

    public Long getEncuestaId() {
        return encuestaId;
    }

    public void setEncuestaId(Long encuestaId) {
        this.encuestaId = encuestaId;
    }

    public List<RespuestaPreguntaDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaPreguntaDTO> respuestas) {
        this.respuestas = respuestas;
    }

    public static class RespuestaPreguntaDTO {
        private Long preguntaId;
        private Long opcionId;

        public Long getPreguntaId() {
            return preguntaId;
        }

        public void setPreguntaId(Long preguntaId) {
            this.preguntaId = preguntaId;
        }

        public Long getOpcionId() {
            return opcionId;
        }

        public void setOpcionId(Long opcionId) {
            this.opcionId = opcionId;
        }
    }
}

