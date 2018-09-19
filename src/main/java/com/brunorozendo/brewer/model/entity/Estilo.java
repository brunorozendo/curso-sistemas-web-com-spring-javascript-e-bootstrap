package com.brunorozendo.brewer.model.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_estilo")
public class Estilo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "tx_nome")
  private String nome;

  @OneToMany(mappedBy = "estilo")
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
