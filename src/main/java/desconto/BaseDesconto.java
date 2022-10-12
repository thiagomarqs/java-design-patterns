package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class BaseDesconto implements Desconto {

    Orcamento orcamento;
    Desconto proximo;

    BaseDesconto() { this.orcamento = null; }
    BaseDesconto(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public void setProximo(Desconto desconto) {
        this.proximo = desconto;
    }

    @Override
    public BigDecimal calcular() {
        return BigDecimal.ZERO;
    }
}
