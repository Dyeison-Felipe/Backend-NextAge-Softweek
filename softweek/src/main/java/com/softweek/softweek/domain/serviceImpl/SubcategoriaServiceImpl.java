package com.softweek.softweek.domain.serviceImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softweek.softweek.domain.dto.SubcategoriaDTO;
import com.softweek.softweek.domain.model.Categoria;
import com.softweek.softweek.domain.model.Subcategoria;
import com.softweek.softweek.domain.repository.Categoriarepository;
import com.softweek.softweek.domain.repository.SubcategoriaRepository;
import com.softweek.softweek.domain.service.SubcategoriaService;
import com.softweek.softweek.domain.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Data
public class SubcategoriaServiceImpl implements SubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;
    private final Categoriarepository categoriarepository;


    @Override
    public ResponseEntity<List<SubcategoriaDTO>> listarSubcategorias() {
        try {

            List<Subcategoria> subcategorias = subcategoriaRepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(subcategorias.stream().map(x -> SubcategoriaDTO.builder()
                    .idSubcategoria(x.getIdSubcategoria())
                    .nome(x.getNome())
                    .dataCriacao(Utils.formataDataString(x.getDataCriacao()))
                    .dataEdicao(Utils.formataDataString(x.getUltimaDataModificada()))
                    .ativo(x.getAtivo())
                    .idCategoria(x.getCategoria().getIdCategoria())
                    .nomeCategoria(x.getCategoria().getNome())
                    .build()).toList());

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<List<SubcategoriaDTO>> listarSubcategoriasCartegoria(Long idCategoria) {
        try {
            List<Subcategoria> subcategorias = subcategoriaRepository.findAllByCategoriaIdCategoria(idCategoria);

            return ResponseEntity.status(HttpStatus.OK).body(subcategorias.stream().map(x -> SubcategoriaDTO.builder()
                    .idSubcategoria(x.getIdSubcategoria())
                    .nome(x.getNome())
                    .dataCriacao(Utils.formataDataString(x.getDataCriacao()))
                    .dataEdicao(Utils.formataDataString(x.getUltimaDataModificada()))
                    .ativo(x.getAtivo())
                    .idCategoria(x.getCategoria().getIdCategoria())
                    .nomeCategoria(x.getCategoria().getNome())
                    .build()).toList());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<SubcategoriaDTO> salvarSubcategoria(SubcategoriaDTO subcategoriaDTO) {

        Categoria categoria = categoriarepository.findById(subcategoriaDTO.getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria inválida!"));

        Subcategoria subcategoria = Subcategoria.builder()
                .nome(subcategoriaDTO.getNome())
                .categoria(categoria)
                .build();

        subcategoria = subcategoriaRepository.save(subcategoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(montarSubcategoriaDTO(subcategoria));
    }

    @Override
    public ResponseEntity<SubcategoriaDTO> atualizarSubcategoria(SubcategoriaDTO subcategoriaDTO) {
        Subcategoria subCatExistente = subcategoriaRepository.findById(subcategoriaDTO.getIdSubcategoria())
                .orElseThrow(() -> new EntityNotFoundException("Subcategoria não encontrada"));

        Subcategoria subcategoriaAtualizada = atualizarCamposSubcat(subcategoriaDTO, subCatExistente);

        subcategoriaAtualizada = subcategoriaRepository.save(subcategoriaAtualizada);

        return ResponseEntity.status(HttpStatus.OK).body(montarSubcategoriaDTO(subcategoriaAtualizada));
    }

    private SubcategoriaDTO montarSubcategoriaDTO(Subcategoria subcategoria) {
        return SubcategoriaDTO.builder()
                .idSubcategoria(subcategoria.getIdSubcategoria())
                .nome(subcategoria.getNome())
                .ativo(subcategoria.getAtivo())
                .dataCriacao(Utils.formataDataString(subcategoria.getDataCriacao()))
                .dataEdicao(Utils.formataDataString(subcategoria.getUltimaDataModificada()))
                .build();
    }

    private Subcategoria atualizarCamposSubcat(SubcategoriaDTO subcategoriaDTO, Subcategoria subCatExistente) {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Map<String, Object> subcategoriaMap = objectMapper.convertValue(subcategoriaDTO, Map.class);

        return (Subcategoria) Utils.atualizarObjetos(Subcategoria.class, subcategoriaMap, subCatExistente);
    }
}
