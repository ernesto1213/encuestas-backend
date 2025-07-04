package com.tuempresa.encuestas.repository;


import com.tuempresa.encuestas.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Long> {
}