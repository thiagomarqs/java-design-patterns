package orcamento.estados;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class BaseSituacaoOrcamento implements SituacaoOrcamento {

    protected Orcamento orcamento;

    public BaseSituacaoOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    public void aprovar() {
        throw new EstadoInvalidoException("Não é possível aprovar.");
    }

    @Override
    public void reprovar() {
        throw new EstadoInvalidoException("Não é possível reprovar.");
    }

    @Override
    public void finalizar() {
        throw new EstadoInvalidoException("Não é possível finalizar.");
    }
}
