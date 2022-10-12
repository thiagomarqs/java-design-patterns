package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoSeValorMaiorQueQuinhentos extends BaseDesconto {

    DescontoSeValorMaiorQueQuinhentos(Orcamento orcamento) {
        super(orcamento);
    }

    @Override
    protected boolean deveEfetuarCalculo() {
        return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
    }

    @Override
    protected BigDecimal efetuarCalculo() {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }
}
