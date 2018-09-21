package com.brunorozendo.brewer.model.entity;

public enum Sabor {

  ADOCICADA("Adocicada"),
  AMARGA("Amarga"),
  FORTE("Forte"),
  FRUTADA("Frutada"),
  SUAVE("Suave");

  private String descricao;

  Sabor(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return this.descricao;
  }
}

