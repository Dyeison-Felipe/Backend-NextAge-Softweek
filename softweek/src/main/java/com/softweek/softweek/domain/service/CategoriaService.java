package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.CategoriaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {

    ResponseEntity<List<CategoriaDTO>> listarCategorias();

    ResponseEntity<CategoriaDTO> salvarCategoria(CategoriaDTO categoriaDTO);

    ResponseEntity<CategoriaDTO> atualizarCategoria(CategoriaDTO categoriaDTO);

    ResponseEntity<String> deletarCategoria(Long id);

    ResponseEntity<CategoriaDTO> listarCategoriaPorId(Long id);



}
