package com.softweek.softweek.domain.service;

import com.softweek.softweek.domain.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO);

    ResponseEntity<String> excluirProduto(Long idProduto);

    ResponseEntity<List<ProdutoDTO>> listarProdutos();

    ResponseEntity<ProdutoDTO> atualizarProduto(ProdutoDTO produtoDTO);

}
