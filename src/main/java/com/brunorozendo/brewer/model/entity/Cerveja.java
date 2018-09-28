package com.brunorozendo.brewer.model.entity;

import com.brunorozendo.brewer.model.services.exception.FieldValueExcepetion;
import com.brunorozendo.brewer.model.validation.NumberNotEmpty;
import com.brunorozendo.brewer.model.validation.Sku;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_cerveja")
public class Cerveja implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cerveja")
  private Integer id;

  @Sku
  @NotBlank
  @Column(name = "tx_sku")
  private String sku;

  @NotBlank
  @Size(max = 30)
  @Column(name = "tx_nome")
  private String nome;

  @NotBlank
  @Size(max = 50)
  @Column(name = "tx_descricao")
  private String descricao;

  @NumberNotEmpty
  @DecimalMin(value = "0.01")
  @DecimalMax(value = "9999999.99")
  @Column(name = "nr_valor")
  private BigDecimal valor;

  @NumberNotEmpty
  @DecimalMin(value = "0.01")
  @DecimalMax(value = "100.0")
  @Column(name = "nr_teor_alcoolico")
  private BigDecimal teorAlcoolico;

  @NumberNotEmpty
  @DecimalMax(value = "100.0")
  @DecimalMin(value = "0.01")
  @Column(name = "nr_comissao")
  private BigDecimal comissao;

  @NumberNotEmpty
  @DecimalMin(value = "0.01")
  @DecimalMax(value = "9999999.99")
  @Column(name = "nr_quantidade_estoque")
  private BigDecimal qtdEstoque;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "tx_origem")
  private Origem origem;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "tx_sabor")
  private Sabor sabor;

  @NotNull
  @JoinColumn(name = "id_estilo")
  @ManyToOne
  private Estilo estilo;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public BigDecimal getTeorAlcoolico() {
    return teorAlcoolico;
  }

  public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
    this.teorAlcoolico = teorAlcoolico;
  }

  public BigDecimal getComissao() {
    return comissao;
  }

  public void setComissao(BigDecimal comissao) {
    this.comissao = comissao;
  }

  public BigDecimal getQtdEstoque() {
    return qtdEstoque;
  }

  public void setQtdEstoque(BigDecimal qtdEstoque) {
    this.qtdEstoque = qtdEstoque;
  }

  public Origem getOrigem() {
    return origem;
  }

  public void setOrigem(Origem origem) {
    this.origem = origem;
  }

  public Sabor getSabor() {
    return sabor;
  }

  public void setSabor(Sabor sabor) {
    this.sabor = sabor;
  }

  public Estilo getEstilo() {
    return estilo;
  }

  public void setEstilo(Estilo estilo) {
    this.estilo = estilo;
  }

  /**
   * Valida&ccedil;&otilde;es antes de gravar no banco.
   */
  @PrePersist
  @PreUpdate
  public void prePersistUpdate() {
    if (this.sku.matches("\\w")) {
      throw new FieldValueExcepetion("sku");
    }
  }
}
