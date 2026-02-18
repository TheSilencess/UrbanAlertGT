package com.urbanalertgt.application.repository;

import com.urbanalertgt.application.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
