package com.softweek.softweek.domain.controller;

import com.softweek.softweek.domain.dto.SubcategoriaDTO;
import com.softweek.softweek.domain.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping(value = "/listar-subcategorias")
    public ResponseEntity<?> listarSubcategorias() {
        try {
            ResponseEntity<?> response = subcategoriaService.listarSubcategorias();
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "/listar-subcategorias-categoria/{idCategoria}")
    public ResponseEntity<?> listarSubcategorias(@PathVariable Long idCategoria) {
        try {
            ResponseEntity<?> response = subcategoriaService.listarSubcategoriasCartegoria(idCategoria);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/salvar-subcategoria")
    public ResponseEntity<?> salvarSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        try {
            ResponseEntity<?> response = subcategoriaService.salvarSubcategoria(subcategoriaDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(value = "/atualizar-subcategoria")
    public ResponseEntity<?> atualizarSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        try {
            ResponseEntity<?> response = subcategoriaService.atualizarSubcategoria(subcategoriaDTO);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
