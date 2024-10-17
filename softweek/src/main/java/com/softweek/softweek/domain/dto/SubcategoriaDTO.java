package com.softweek.softweek.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubcategoriaDTO {

    private Long idSubcategoria;

    private Long idCategoria;

    private String nomeCategoria;

    private String nome;

    private Boolean ativo;

    private String dataCriacao;

    private String dataEdicao;
}
