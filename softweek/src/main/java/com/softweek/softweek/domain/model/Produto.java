package com.softweek.softweek.domain.model;

import com.softweek.softweek.domain.auditoria.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Produto extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subcategoria", nullable = false)
    private Subcategoria subcategoria;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "preco")
    private Double preco;
}
