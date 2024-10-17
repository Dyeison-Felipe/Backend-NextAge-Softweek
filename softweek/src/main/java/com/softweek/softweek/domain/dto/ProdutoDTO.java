package com.softweek.softweek.domain.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {

    private Long idProduto;

    private String nome;

    private String descricao;

    private Double preco;

    private Boolean ativo;

    private String dataCriacao;

    private String dataEdicao;

    private Long idSubcategoria;

    private String nomeSubcategoria;

    private Long idCategoria;

    private String nomeCategoria;
}
