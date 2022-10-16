package imposto;

import orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMScomISS implements Imposto {

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        var valorICMS = new ICMS().calcular(orcamento);
        var valorISS = new ISS().calcular(orcamento);
        return valorICMS.add(valorISS);
    }

}
