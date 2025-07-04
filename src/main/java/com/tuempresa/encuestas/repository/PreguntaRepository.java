package com.tuempresa.encuestas.repository;


import com.tuempresa.encuestas.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}