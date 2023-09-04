package br.com.alura.tdd.testes;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

public class CalculadoraTest {
	
	@Test
	public void somarInteirosPositivos() {
		
		Calculadora calculadora = new Calculadora();
		int soma = calculadora.somar(3, 7);
		Assert.assertEquals(11, soma);
		
	}
	
}
