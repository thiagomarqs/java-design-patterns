package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class SemDesconto extends BaseDesconto {

    SemDesconto() {
        super();
    }

    @Override
    protected boolean deveEfetuarCalculo() {
        return true;
    }

    @Override
    protected BigDecimal efetuarCalculo() {
        return BigDecimal.ZERO;
    }

}
