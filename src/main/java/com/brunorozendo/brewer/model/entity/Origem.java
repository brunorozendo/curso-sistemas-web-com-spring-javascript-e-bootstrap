package com.brunorozendo.brewer.model.entity;

public enum Origem {

  NACIONAL("Nacional"),
  INTERNACIONAL("Internacional");

  private String descricao;

  Origem(String descricao) {
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