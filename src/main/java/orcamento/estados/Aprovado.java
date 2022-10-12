package orcamento.estados;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class Aprovado extends BaseSituacaoOrcamento {

    public Aprovado(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void reprovar() {
        this.orcamento.setSituacao(new Reprovado(this.orcamento));
    }

    public void finalizar() {
        this.orcamento.setSituacao(new Finalizado(this.orcamento));
    }
}
