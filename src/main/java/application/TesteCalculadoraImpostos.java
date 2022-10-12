package application;

import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteCalculadoraImpostos {
  
  public static void main(String[] args) {
    
    CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
    Orcamento orcamento = new Orcamento(new BigDecimal(25000.00), 1, null);
    System.out.println(calculadora.calcular(orcamento, new ICMS()));
    
  }

}
