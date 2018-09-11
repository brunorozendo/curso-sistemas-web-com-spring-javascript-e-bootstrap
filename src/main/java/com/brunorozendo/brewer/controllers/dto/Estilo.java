package com.brunorozendo.brewer.controllers.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Estilo implements Serializable {

  private Integer id;

  @NotBlank
  @Size(max = 20)
  private String nome;

  private Set<Cerveja> cervejas;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Cerveja> getCervejas() {
    return cervejas;
  }

  public void setCervejas(Set<Cerveja> cervejas) {
    this.cervejas = cervejas;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Estilo estilo = (Estilo) o;
    return Objects.equals(id, estilo.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
