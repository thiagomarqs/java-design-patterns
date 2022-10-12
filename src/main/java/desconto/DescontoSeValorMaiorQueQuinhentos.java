package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoSeValorMaiorQueQuinhentos extends BaseDesconto {

    DescontoSeValorMaiorQueQuinhentos(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    public BigDecimal calcular() {
        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        }
        return this.proximo.calcular();
    }
}
