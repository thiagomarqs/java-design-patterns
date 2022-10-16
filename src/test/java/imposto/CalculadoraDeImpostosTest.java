package imposto;

import orcamento.ItemOrcamento;
import orcamento.Orcamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraDeImpostosTest {

    private CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
    private Orcamento orcamento = new Orcamento();

    @BeforeEach
    void setup() {
        this.orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("1000.00")));
    }

    @AfterEach
    void tearDown() {
        this.orcamento = new Orcamento();
    }

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
        var tax = calculadora.calcular(this.orcamento, new ICMS(new ISS()));
        assertEquals(new BigDecimal("160.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsICMS() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("0.00"));
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item);
        var tax = calculadora.calcular(orcamento, new ICMS());
        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsISS() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("0.00"));
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item);
        var tax = calculadora.calcular(orcamento, new ISS());
        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    void taxShouldBeZeroIfBudgetValueIsZeroAndTaxIsICMSWithISS() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("0.00"));
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item);
        var tax = calculadora.calcular(orcamento, new ICMS(new ISS()));
        assertEquals(new BigDecimal("0.00"), tax);
    }

}