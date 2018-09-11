package com.brunorozendo.brewer.controllers.dto;

import com.brunorozendo.brewer.model.Origem;
import com.brunorozendo.brewer.model.Sabor;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cerveja implements Serializable {

  private Integer id;

  @NotBlank
  private String sku;

  @NotBlank
  @Size(max = 30)
  private String nome;

  @NotBlank
  @Size(max = 50)
  private String descricao;

  private BigDecimal valor;

  private Float teorAlcoolico;

  private Float comissao;

  private Float qtdEstoque;

  private Origem origem;

  private Sabor sabor;

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

  public Float getTeorAlcoolico() {
    return teorAlcoolico;
  }

  public void setTeorAlcoolico(Float teorAlcoolico) {
    this.teorAlcoolico = teorAlcoolico;
  }

  public Float getComissao() {
    return comissao;
  }

  public void setComissao(Float comissao) {
    this.comissao = comissao;
  }

  public Float getQtdEstoque() {
    return qtdEstoque;
  }

  public void setQtdEstoque(Float qtdEstoque) {
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
}
