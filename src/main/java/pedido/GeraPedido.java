package pedido;

import acao.AcaoAposGerarPedido;
import orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GeraPedido {

    private String cliente;
    private BigDecimal valorOrcamento;
    private Integer quantidadeItens;

    private List<AcaoAposGerarPedido> acoes;

    public GeraPedido(String cliente, BigDecimal valorOrcamento, Integer quantidadeItens, List<AcaoAposGerarPedido> acoes) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
        this.acoes = acoes;
    }

    public void executar() {
        Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
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
