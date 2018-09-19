package com.brunorozendo.brewer.model.entity;

import javax.validation.constraints.NotBlank;

public class Estado {

  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String sigla;

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

  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }
}
