package pedido;

import orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeraPedido {

    private String cliente;
    private BigDecimal valorOrcamento;
    private Integer quantidadeItens;

    public GeraPedido(String cliente, BigDecimal valorOrcamento, Integer quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public void executar() {
        Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
        Pedido pedido = new Pedido(this.cliente, LocalDateTime.now(), orcamento);

        System.out.println("Salvar no banco de dados.");
        System.out.println("Enviar e-mail.");
    }

}
