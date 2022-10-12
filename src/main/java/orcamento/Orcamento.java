package orcamento;

import java.math.BigDecimal;

public class Orcamento {

  private BigDecimal valor;
  private Integer quantidadeItens;

  private SituacaoOrcamento situacao;

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
    var valorDoDescontoExtra = BigDecimal.ZERO;

    if(situacao.equals(SituacaoOrcamento.EM_ANALISE)) {
      valorDoDescontoExtra = this.valor.multiply(new BigDecimal("0.05"));
    }
    else if(situacao.equals(SituacaoOrcamento.APROVADO)) {
      valorDoDescontoExtra = this.valor.multiply(new BigDecimal("0.02"));
    }

    this.valor = this.valor.subtract(valorDoDescontoExtra);
  }

  public void aprovar() {
    this.situacao = SituacaoOrcamento.APROVADO;
  }

  public void reprovar() {
    this.situacao = SituacaoOrcamento.REPROVADO;
  }

  public void setSituacao(SituacaoOrcamento situacao) {
    this.situacao = situacao;
  }

  public SituacaoOrcamento getSituacao() {
    return this.situacao;
  }

}