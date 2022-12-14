package orcamento;

import orcamento.estados.EmAnalise;
import orcamento.estados.Finalizado;
import orcamento.estados.SituacaoOrcamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel{

  private BigDecimal valor = BigDecimal.ZERO;
  private SituacaoOrcamento situacao = new EmAnalise(this);
  private List<Orcavel> itens = new ArrayList<>();

  public Orcamento() {}

  public Orcamento(SituacaoOrcamento situacao) {
    this.situacao = situacao;
  }

  public BigDecimal getValor() {

    // Simulando demora na obtenção do valor.
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return valor.setScale(2, RoundingMode.HALF_UP);
  }

  public Integer getQuantidadeItens() {
    return this.itens.size();
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

  public boolean isFinalizado() {
    return this.situacao instanceof Finalizado;
  }

  public void adicionarItem(Orcavel item) {
    this.valor = valor.add(item.getValor());
    this.itens.add(item);
  }

  public List<Orcavel> getItens() {
    return itens;
  }
}