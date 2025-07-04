package com.tuempresa.encuestas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuempresa.encuestas.model.Encuesta;

@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
}
