package pedido;

import acao.AcaoAposGerarPedido;
import orcamento.ItemOrcamento;
import orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class GeraPedido {

    private String cliente;
    private List<AcaoAposGerarPedido> acoes;
    private List<ItemOrcamento> itens;

    public GeraPedido(String cliente, List<ItemOrcamento> itens, List<AcaoAposGerarPedido> acoes) {
        this.cliente = cliente;
        this.itens = itens;
        this.acoes = acoes;
    }

    public void executar() {
        Orcamento orcamento = new Orcamento();
        this.itens.forEach(orcamento::adicionarItem);
        Pedido pedido = new Pedido(this.cliente, LocalDateTime.now(), orcamento);
        this.executarAcoes(pedido);
    }

    private void executarAcoes(Pedido pedido) {
        this.acoes.forEach(a -> a.executar(pedido));
    }

    public void setAcoes(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }
}
