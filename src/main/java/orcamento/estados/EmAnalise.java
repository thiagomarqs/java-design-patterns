package orcamento.estados;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class EmAnalise extends BaseSituacaoOrcamento {

    public EmAnalise(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void aprovar() {
        this.orcamento.setSituacao(new Aprovado(this.orcamento));
    }

    @Override
    public void reprovar() {
        this.orcamento.setSituacao(new Reprovado(this.orcamento));
    }

}
