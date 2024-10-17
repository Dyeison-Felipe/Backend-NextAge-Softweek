package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.SubcategoriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubcategoriaService {

    ResponseEntity<List<SubcategoriaDTO>> listarSubcategorias();
    ResponseEntity<List<SubcategoriaDTO>> listarSubcategoriasCartegoria(Long idCategoria);

    ResponseEntity<SubcategoriaDTO> salvarSubcategoria(SubcategoriaDTO subcategoriaDTO);

    ResponseEntity<SubcategoriaDTO> atualizarSubcategoria(SubcategoriaDTO subcategoriaDTO);
}
