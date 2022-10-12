package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoSeMaisDeCincoItens extends BaseDesconto {

    public DescontoSeMaisDeCincoItens(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    protected boolean deveEfetuarCalculo() {
        return orcamento.getQuantidadeItens() > 5;
    }

    @Override
    protected BigDecimal efetuarCalculo() {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
