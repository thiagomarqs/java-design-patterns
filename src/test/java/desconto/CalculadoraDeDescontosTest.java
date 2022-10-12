package desconto;

import orcamento.Orcamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDescontosTest {

    private CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

    @Test
    void discountShouldBeOfTenPercentIfQuantityOfItemsIsGreaterThanFive() {
        Orcamento o = new Orcamento(new BigDecimal("2300"), 6);
        var desconto = calculadora.calcular(o);
        assertEquals(new BigDecimal("230.0"), desconto);
    }

    @Test
    void discountShouldBeOfFivePercentIfValueIsGreaterThanFiveHundred() {
        Orcamento o = new Orcamento(new BigDecimal("1000"), 1);
        var desconto = calculadora.calcular(o);
        assertEquals(new BigDecimal("50.00"), desconto);
    }

    @Test
    void discountShouldBeOfZeroPercent() {
        Orcamento o = new Orcamento(new BigDecimal("499"), 5);
        var desconto = calculadora.calcular(o);
        assertEquals(BigDecimal.ZERO, desconto);
    }
}