package application;

import java.math.BigDecimal;

import imposto.CalculadoraDeImpostos;
import imposto.TipoImposto;
import orcamento.Orcamento;

public class App {
  
  public static void main(String[] args) {
    
    CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
    Orcamento orcamento = new Orcamento(new BigDecimal(25000.00));
    System.out.println(calculadora.calcular(orcamento, TipoImposto.ICMS));
  }

}
