package acao;

import pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Salvar no banco de dados.");
    }
}
