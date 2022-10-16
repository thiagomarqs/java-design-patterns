package application;

import acao.AcaoAposGerarPedido;
import acao.EnviarEmailPedido;
import acao.SalvarPedidoNoBancoDeDados;
import orcamento.ItemOrcamento;
import pedido.GeraPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestePedidos {

    public static void main(String[] args) {
        BigDecimal valorOrcamento = new BigDecimal("2300.00");
        Integer quantidadeItens = 4;
        String cliente = "João Zinho";
        LocalDateTime data = LocalDateTime.now();

        List<AcaoAposGerarPedido> acoes = Arrays.asList(
            new EnviarEmailPedido(),
            new SalvarPedidoNoBancoDeDados()
        );

        List<ItemOrcamento> itens = Arrays.asList(
            new ItemOrcamento(new BigDecimal("100.00")),
            new ItemOrcamento(new BigDecimal("320.00"))
        );

        GeraPedido geraPedido = new GeraPedido(cliente, itens, acoes);

        geraPedido.executar();
    }
}
