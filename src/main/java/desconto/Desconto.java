package desconto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public interface Desconto {

    void setProximo(Desconto desconto);
    BigDecimal calcular();

}
