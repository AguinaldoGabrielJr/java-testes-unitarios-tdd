package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	public void reajusteADesejar() {
		 ReajusteService reajusteService = new ReajusteService();
		 Funcionario funcionario = new Funcionario("Racquel", LocalDate.now(), new BigDecimal("1000.00"));
		 
		 reajusteService.concederReajust(funcionario, Desempenho.A_DESEJAR);
		 assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteBom() {
		 ReajusteService reajusteService = new ReajusteService();
		 Funcionario funcionario = new Funcionario("Guina", LocalDate.now(), new BigDecimal("1000.00"));
		 
		 reajusteService.concederReajust(funcionario, Desempenho.BOM);
		 assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteAOtimo() {
		 ReajusteService reajusteService = new ReajusteService();
		 Funcionario funcionario = new Funcionario("Julio", LocalDate.now(), new BigDecimal("1000.00"));
		 
		 reajusteService.concederReajust(funcionario, Desempenho.OTIMO);
		 assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
