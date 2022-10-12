package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {

    public BigDecimal calcular(Orcamento orcamento) {
        var descontoSeMaisDeCincoItens = new DescontoSeMaisDeCincoItens(orcamento);
        var descontoSeValorMaiorQueQuinhentos = new DescontoSeValorMaiorQueQuinhentos(orcamento);

        descontoSeMaisDeCincoItens.setProximo(descontoSeValorMaiorQueQuinhentos);
        descontoSeValorMaiorQueQuinhentos.setProximo(new SemDesconto());

        return descontoSeMaisDeCincoItens.calcular();
    }
}
