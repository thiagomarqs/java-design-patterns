package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoSeMaisDeCincoItens extends BaseDesconto {

    public DescontoSeMaisDeCincoItens(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    public BigDecimal calcular() {
        if (orcamento.getQuantidadeItens() > 5) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        return this.proximo.calcular();
    }
}
