package application;

import http.JavaHttpAdapter;
import orcamento.ItemOrcamento;
import orcamento.Orcamento;
import orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TesteAdapter {

    public static void main(String[] args) {
        var registroOrcamento = new RegistroDeOrcamento(new JavaHttpAdapter(), "https://api-inexistente.exemplo");
        ItemOrcamento item = new ItemOrcamento(new BigDecimal("2000.00"));
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(item);

        orcamento.aprovar();
        orcamento.finalizar();

        registroOrcamento.registrar(orcamento);
    }

}
