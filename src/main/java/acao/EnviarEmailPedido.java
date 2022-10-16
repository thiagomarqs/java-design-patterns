package acao;

import pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviar e-mail.");
    }

}
