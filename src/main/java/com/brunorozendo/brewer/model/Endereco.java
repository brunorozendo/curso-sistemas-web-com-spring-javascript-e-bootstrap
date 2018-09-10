package com.brunorozendo.brewer.model;

import javax.validation.constraints.NotBlank;

public class Endereco {

  @NotBlank
  private String logradouro;
  @NotBlank
  private String numero;
  @NotBlank
  private String complemento;
  @NotBlank
  private String cep;
  @NotBlank
  private Cidade cidade;
  @NotBlank
  private Estado estado;

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }
}
