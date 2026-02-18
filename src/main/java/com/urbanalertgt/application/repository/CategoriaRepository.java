package com.urbanalertgt.application.repository;

import com.urbanalertgt.application.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
