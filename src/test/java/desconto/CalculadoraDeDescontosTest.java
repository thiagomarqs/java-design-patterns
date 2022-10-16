package desconto;

import orcamento.ItemOrcamento;
import orcamento.Orcamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDeDescontosTest {

    private CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

    @Test
    void discountShouldBeOfTenPercentIfQuantityOfItemsIsGreaterThanFive() {
        Orcamento o = new Orcamento();

        o.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        o.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
        o.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        o.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        o.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        o.adicionarItem(new ItemOrcamento(new BigDecimal("500")));

        var desconto = calculadora.calcular(o);
        assertEquals(new BigDecimal("230.0"), desconto);
    }

    @Test
    void discountShouldBeOfFivePercentIfValueIsGreaterThanFiveHundred() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("1000"));
        Orcamento o = new Orcamento();
        o.adicionarItem(item);
        var desconto = calculadora.calcular(o);
        assertEquals(new BigDecimal("50.00"), desconto);
    }

    @Test
    void discountShouldBeOfZeroPercent() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("499"));
        Orcamento o = new Orcamento();
        o.adicionarItem(item);
        var desconto = calculadora.calcular(o);
        assertEquals(BigDecimal.ZERO, desconto);
    }

}