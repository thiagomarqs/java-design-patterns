package orcamento;

import orcamento.estados.EmAnalise;
import orcamento.estados.SituacaoOrcamento;

import java.math.BigDecimal;

public class Orcamento {

  private BigDecimal valor;
  private Integer quantidadeItens;

  private SituacaoOrcamento situacao;

  public Orcamento(BigDecimal valor, Integer quantidadeItens) {
    this.valor = valor;
    this.quantidadeItens = quantidadeItens;
    this.situacao = new EmAnalise(this);
  }

  public Orcamento(BigDecimal valor, Integer quantidadeItens, SituacaoOrcamento situacao) {
    this.valor = valor;
    this.quantidadeItens = quantidadeItens;
    this.situacao = situacao;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public Integer getQuantidadeItens() {
    return quantidadeItens;
  }

  public void setQuantidadeItens(Integer quantidadeItens) {
    this.quantidadeItens = quantidadeItens;
  }

  public void aplicarDescontoExtra() {
    var valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
    this.valor = this.valor.subtract(valorDoDescontoExtra);
  }

  public void aprovar() {
    this.situacao.aprovar();
  }

  public void reprovar() {
    this.situacao.reprovar();
  }

  public void finalizar() {
    this.situacao.finalizar();
  }

  public void setSituacao(SituacaoOrcamento situacao) {
    this.situacao = situacao;
  }

  public SituacaoOrcamento getSituacao() {
    return this.situacao;
  }

}