package com.softweek.softweek.domain.model;

import com.softweek.softweek.domain.auditoria.Audit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subcategoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Subcategoria extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "nome", length = 50)
    private String nome;

    @OneToMany(mappedBy = "subcategoria", cascade =  CascadeType.ALL, orphanRemoval = true)
    private Set<Produto> produtos = new HashSet<>();
}
