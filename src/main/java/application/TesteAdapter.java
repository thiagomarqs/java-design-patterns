package application;

import http.JavaHttpAdapter;
import orcamento.Orcamento;
import orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TesteAdapter {

    public static void main(String[] args) {
        var registroOrcamento = new RegistroDeOrcamento(new JavaHttpAdapter(), "https://api-inexistente.exemplo");
        var orcamento = new Orcamento(new BigDecimal("2000"), 30);
        orcamento.aprovar();
        orcamento.finalizar();

        registroOrcamento.registrar(orcamento);
    }

}
