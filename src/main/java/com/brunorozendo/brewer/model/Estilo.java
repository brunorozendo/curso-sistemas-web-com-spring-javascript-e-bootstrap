package com.brunorozendo.brewer.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Estilo implements Serializable {

  private Long id;

  @NotBlank
  @Size(max = 20)

  private String nome;


  private List<Cerveja> cervejas;

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

  public List<Cerveja> getCervejas() {
    return cervejas;
  }

  public void setCervejas(List<Cerveja> cervejas) {
    this.cervejas = cervejas;
  }


}
