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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_estilo")
public class Estilo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_estilo")
  @Getter
  @Setter
  private Integer id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "tx_nome")
  @Getter
  @Setter
  private String nome;

  @OneToMany(mappedBy = "estilo")
  @Getter
  @Setter
  private Set<Cerveja> cervejas;


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
