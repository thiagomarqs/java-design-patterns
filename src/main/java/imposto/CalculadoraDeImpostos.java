package imposto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import orcamento.Orcamento;

public class CalculadoraDeImpostos {

  public BigDecimal calcular(Orcamento orcamento, Imposto tipoImposto) {
    return tipoImposto.calcular(orcamento).setScale(2, RoundingMode.HALF_UP);
  }

}
