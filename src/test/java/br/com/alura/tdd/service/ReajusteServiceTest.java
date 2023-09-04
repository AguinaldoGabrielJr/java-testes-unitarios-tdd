package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService reajusteService;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		System.out.println("Roda antes de cada caso!!");
		this.reajusteService = new ReajusteService();
		this.funcionario = new Funcionario("Racquel", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@AfterEach
	public void finalizar() {
		System.out.println("Roda após cada caso!!");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Roda antes de qualquer coisa, e PRECISA ser static");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Roda depois de tudo, e PRECISA ser static");
	}
	
	@Test
	public void reajusteADesejar() {
		reajusteService.concederReajust(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteBom() {
		reajusteService.concederReajust(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteAOtimo() {
		reajusteService.concederReajust(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
