package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public abstract class Imposto {

  private Imposto outro;

  public Imposto() {};

  public Imposto(Imposto outro) {
    this.outro = outro;
  }

  protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

  public BigDecimal calcular(Orcamento orcamento) {
    BigDecimal valorImposto = this.realizarCalculo(orcamento);
    BigDecimal valorOutroImposto = BigDecimal.ZERO;

    if(this.outro != null) {
      valorOutroImposto = outro.calcular(orcamento);
    }

    return valorImposto.add(valorOutroImposto);
  }
  
}
