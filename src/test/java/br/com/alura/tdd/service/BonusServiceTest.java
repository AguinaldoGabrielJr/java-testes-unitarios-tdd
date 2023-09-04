package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;

	@BeforeEach
	public void inicializar() {
		System.out.println("Roda antes de cada caso!!");
		this.service = new BonusService();
		
	}
	
	@Test
	public void bonuSalarioMuitoAltoTest() {
		
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("25000"))));

	}

	@Test
	public void bonuSalario10PorcentoTest() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	public void bonuSalarioSalarioExatos10kTest() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
