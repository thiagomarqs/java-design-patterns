package imposto;

import orcamento.Orcamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeImpostosTest {

    private CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
    private Orcamento orcamento = new Orcamento(new BigDecimal("1000.00"), 5);

    @Test
    void taxShouldBeOfTenPercentIfTaxIsICMS() {
        var tax = calculadora.calcular(this.orcamento, new ICMS());
        assertEquals(new BigDecimal("100.00"), tax);
    }

    @Test
    void taxShouldBeOfSixPercentIfTaxIsISS() {
        var tax = calculadora.calcular(this.orcamento, new ISS());
        assertEquals(new BigDecimal("60.00"), tax);
    }

    @Test
    void taxShouldBeOfSixteenPercentIfTaxIsICMSWithISS() {
        var tax = calculadora.calcular(this.orcamento, new ICMScomISS());
        assertEquals(new BigDecimal("160.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsICMS() {
        var orcamento = new Orcamento(new BigDecimal("0.00"), 1);
        var tax = calculadora.calcular(orcamento, new ICMS());
        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsISS() {
        var orcamento = new Orcamento(new BigDecimal("0.00"), 1);
        var tax = calculadora.calcular(orcamento, new ISS());
        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsICMSWithISS() {
        var orcamento = new Orcamento(new BigDecimal("0.00"), 1);
        var tax = calculadora.calcular(orcamento, new ICMScomISS());
        assertEquals(new BigDecimal("0.00"), tax);
    }

}