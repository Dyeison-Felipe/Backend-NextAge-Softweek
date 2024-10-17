package com.softweek.softweek.domain.repository;

import com.softweek.softweek.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Categoriarepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByIdCategoriaAndAtivoTrue(Long id);
}
