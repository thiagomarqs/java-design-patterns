package orcamento;

import orcamento.estados.Aprovado;
import orcamento.estados.EstadoInvalidoException;
import orcamento.estados.Finalizado;
import orcamento.estados.Reprovado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

import static org.junit.jupiter.api.Assertions.*;

class OrcamentoTest {

    @Test
    void shouldApplyFivePercentOfExtraDiscount() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.aplicarDescontoExtra();

        assertEquals(new BigDecimal("1900.00"), o.getValor());
    }

    @Test
    void shouldApplyTwoPercentOfExtraDiscount() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("1000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Aprovado(o));
        o.aplicarDescontoExtra();

        assertEquals(new BigDecimal("980.00"), o.getValor());
    }

    @Test
    void shouldApplyNoExtraDiscount() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Reprovado(o));
        o.aplicarDescontoExtra();

        assertEquals(new BigDecimal("2000.00"), o.getValor());
    }

    @Test
    void shouldApprove() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.aprovar();

        assertInstanceOf(Aprovado.class, o.getSituacao());
    }

    @Test
    void shouldReject() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.reprovar();

        assertInstanceOf(Reprovado.class, o.getSituacao());
    }

    @Test
    void shouldNotRejectIfAlreadyRejected() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Reprovado(o));

        assertThrows(EstadoInvalidoException.class, o::reprovar);
    }

    @Test
    void shouldNotRejectIfAlreadyFinished() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Finalizado(o));

        assertThrows(EstadoInvalidoException.class, o::reprovar);
    }

    @Test
    void shouldFinish() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Aprovado(o));
        o.finalizar();

        assertInstanceOf(Finalizado.class, o.getSituacao());
    }

    @Test
    void shouldNotFinishIfInAnalysis() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);

        assertThrows(EstadoInvalidoException.class, o::finalizar);
    }

    @Test
    void shouldNotFinishIfAlreadyFinished() {
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento o = new Orcamento();

        o.adicionarItem(item);
        o.setSituacao(new Finalizado(o));

        assertThrows(EstadoInvalidoException.class, o::finalizar);
    }

    @Test
    void shouldAllowBothBudgetAndBudgetItemToBeAddedToABudget() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200.00")));

        Orcamento orcamentoAntigo = new Orcamento();
        orcamentoAntigo.adicionarItem(new ItemOrcamento(new BigDecimal("340.00")));
        orcamentoAntigo.reprovar();

        orcamento.adicionarItem(orcamentoAntigo);

        assertEquals(new BigDecimal("540.00"), orcamento.getValor());
    }

    @Test
    void shouldTakeTwoSecondsOnFirstCallToGetValor() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200.00")));
        OrcamentoProxy proxy = new OrcamentoProxy(orcamento);

        assertTimeout(Duration.between(Instant.ofEpochMilli(0), Instant.ofEpochMilli(2100)), () -> proxy.getValor());
    }

    @Test
    void shouldNotTakeTwoSecondsOnSecondCallToGetValor() {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200.00")));
        OrcamentoProxy proxy = new OrcamentoProxy(orcamento);

        proxy.getValor();
        assertTimeout(Duration.between(Instant.ofEpochMilli(0), Instant.ofEpochMilli(100)), () -> proxy.getValor());
    }

}