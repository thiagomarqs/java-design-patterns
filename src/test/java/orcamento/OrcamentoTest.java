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

}