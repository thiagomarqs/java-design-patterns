package application;

import orcamento.Orcamento;
import pedido.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestePedidos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("2300.00"), 4);
        String cliente = "João Zinho";
        LocalDateTime data = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente, data, orcamento);

        System.out.println("Salvar no banco de dados.");
        System.out.println("Enviar e-mail.");
    }
}
