package orcamento.estados;

import orcamento.Orcamento;

import java.math.BigDecimal;

public interface SituacaoOrcamento {

    BigDecimal calcularValorDescontoExtra(Orcamento orcamento);
    void aprovar();
    void reprovar();
    void finalizar();
}
