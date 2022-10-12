package orcamento;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrcamentoTest {

    @Test
    void shouldApplyFivePercentOfExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5, SituacaoOrcamento.EM_ANALISE);
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("1900.00"), o.getValor());
    }

    @Test
    void shouldApplyTwoPercentOfExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("1000"), 5, SituacaoOrcamento.APROVADO);
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("980.00"), o.getValor());
    }

    @Test
    void shouldApplyNoExtraDiscount() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5, SituacaoOrcamento.REPROVADO);
        o.aplicarDescontoExtra();
        assertEquals(new BigDecimal("2000"), o.getValor());
    }

    @Test
    void shouldApprove() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5, SituacaoOrcamento.EM_ANALISE);
        o.aprovar();
        assertEquals(SituacaoOrcamento.APROVADO, o.getSituacao());
    }

    @Test
    void shouldReject() {
        Orcamento o = new Orcamento(new BigDecimal("2000"), 5, SituacaoOrcamento.EM_ANALISE);
        o.reprovar();
        assertEquals(SituacaoOrcamento.REPROVADO, o.getSituacao());
    }

}