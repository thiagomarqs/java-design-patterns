package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public interface Imposto {
  
  public BigDecimal calcular(Orcamento orcamento);
  
}
