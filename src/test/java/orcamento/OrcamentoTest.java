package orcamento;

import orcamento.estados.Aprovado;
import orcamento.estados.EstadoInvalidoException;
import orcamento.estados.Finalizado;
import orcamento.estados.Reprovado;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrcamentoTest {

    @Test
    void shouldApplyFivePercentOfExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("1900.00"), o.getValor());
    }

    @Test
    void shouldApplyTwoPercentOfExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("1000"), 5);
        o.setSituacao(new Aprovado(o));
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("980.00"), o.getValor());
    }

    @Test
    void shouldApplyNoExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.setSituacao(new Reprovado(o));
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("2000"), o.getValor());
    }

    @Test
    void shouldApprove() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.aprovar();
        assertInstanceOf(Aprovado.class, o.getSituacao());
    }

    @Test
    void shouldReject() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.reprovar();
        assertInstanceOf(Reprovado.class, o.getSituacao());
    }

    @Test
    void shouldNotRejectIfAlreadyRejected() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.setSituacao(new Reprovado(o));
        assertThrows(EstadoInvalidoException.class, o::reprovar);
    }

    @Test
    void shouldNotRejectIfAlreadyFinished() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.setSituacao(new Finalizado(o));
        assertThrows(EstadoInvalidoException.class, o::reprovar);
    }

    @Test
    void shouldFinish() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.setSituacao(new Aprovado(o));
        o.finalizar();
        assertInstanceOf(Finalizado.class, o.getSituacao());
    }

    @Test
    void shouldNotFinishIfInAnalysis() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        assertThrows(EstadoInvalidoException.class, o::finalizar);
    }

    @Test
    void shouldNotFinishIfAlreadyFinished() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5);
        o.setSituacao(new Finalizado(o));
        assertThrows(EstadoInvalidoException.class, o::finalizar);
    }

}