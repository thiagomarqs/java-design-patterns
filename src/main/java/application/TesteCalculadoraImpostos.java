package application;

import java.math.BigDecimal;

import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import orcamento.Orcamento;
import orcamento.SituacaoOrcamento;

public class TesteCalculadoraImpostos {
  
  public static void main(String[] args) {
    
    CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
    Orcamento orcamento = new Orcamento(new BigDecimal(25000.00), 1, SituacaoOrcamento.APROVADO);
    System.out.println(calculadora.calcular(orcamento, new ICMS()));
    
  }

}
