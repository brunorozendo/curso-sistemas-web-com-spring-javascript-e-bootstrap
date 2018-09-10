package com.brunorozendo.brewer.model;

import java.util.List;

public class Grupo {


  private Long id;
  private String nome;
  private List<Permissao> permissoes;

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

  public List<Permissao> getPermissoes() {
    return permissoes;
  }

  public void setPermissoes(List<Permissao> permissoes) {
    this.permissoes = permissoes;
  }
}
