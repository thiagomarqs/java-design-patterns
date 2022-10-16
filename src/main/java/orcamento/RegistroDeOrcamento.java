package orcamento;

import http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;
    private String url;

    public RegistroDeOrcamento(HttpAdapter http, String url) {
        this.http = http;
        this.url = url;
    }

    public void registrar(Orcamento orcamento) {
        if(!orcamento.isFinalizado()) {
            throw new RuntimeException("O orçamento não está finalizado. Só é possível registrar orçamentos finalizados.");
        }

        Map<String, Object> dados = Map.of(
            "valor", orcamento.getValor(),
            "quantidadeItens", orcamento.getQuantidadeItens()
        );
        this.http.post(this.url, dados);
    }
}
