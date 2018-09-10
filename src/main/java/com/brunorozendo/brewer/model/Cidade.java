package com.brunorozendo.brewer.model;

import javax.validation.constraints.NotBlank;

public class Cidade {


    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
