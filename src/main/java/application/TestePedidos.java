package application;

import pedido.GeraPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestePedidos {

    public static void main(String[] args) {
        BigDecimal valorOrcamento = new BigDecimal("2300.00");
        Integer quantidadeItens = 4;
        String cliente = "João Zinho";
        LocalDateTime data = LocalDateTime.now();

        GeraPedido geraPedido = new GeraPedido(cliente, valorOrcamento, quantidadeItens);

        geraPedido.executar();
    }
}
