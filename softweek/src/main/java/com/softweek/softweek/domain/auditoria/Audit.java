package com.softweek.softweek.domain.auditoria;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit {

    @CreatedBy
    @Column(name = "criado_por", nullable = true, length = 50, updatable = false)
    private String criado_por = "user";

    @CreatedDate
    @Column(name = "data_criacao", updatable = false)
    private Date dataCriacao = new Date();

    @LastModifiedBy
    @Column(name = "ultima_modificacao_por", length = 50)
    private String ultimaModificacaoPor = "user";

    @LastModifiedDate
    @Column(name = "ultima_data_modificada")
    private Date ultimaDataModificada = new Date();

    @Column(name = "ativo")
    private Boolean ativo = true;
}
