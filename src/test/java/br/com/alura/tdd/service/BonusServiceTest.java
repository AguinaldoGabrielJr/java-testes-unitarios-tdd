package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonuSalarioMuitoAltoTest() {
		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("25000"))));

	}

	@Test
	void bonuSalario10PorcentoTest() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonuSalarioSalarioExatos10kTest() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Guina", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
