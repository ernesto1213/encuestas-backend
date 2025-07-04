package com.tuempresa.encuestas.repository;

import com.tuempresa.encuestas.Dtos.Agregado;
import com.tuempresa.encuestas.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    @Query("""
        SELECT new com.tuempresa.encuestas.Dtos.Agregado(
               r.preguntaId, r.opcionId, COUNT(r))
        FROM Respuesta r
        WHERE r.encuestaId = :encuestaId
        GROUP BY r.preguntaId, r.opcionId
    """)
    List<Agregado> contarPorPreguntaYopcion(@Param("encuestaId") Long encuestaId);
}
