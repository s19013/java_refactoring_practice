package com.example.refactoring;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.example.refactoring.DeliveryDate;

class DeliveryDateTest {
	@Test
	void 配送日のテスト() {
		/*new DeliveryDate();
		assertEquals(1,1);
		new DeliveryDate().getDeliveryDate();
		assertEquals(1,1);*/
		LocalDate actualDate = new DeliveryDate().getDeliveryDate();
		assertEquals(LocalDate.of(2024,1,31),actualDate);
	}

	@Test
	//void _配送日のテスト() {
	void _小の月の月末になる場合のテスト() {
		LocalDate actualDate = new DeliveryDate().getDeliveryDate();
		assertEquals(LocalDate.of(2020,9,30),actualDate);
	}

	@Test
	void _大の月の月末になる場合のテスト() {
		LocalDate actualDate = new DeliveryDate().getDeliveryDate();
		assertEquals(LocalDate.of(2020,10,31),actualDate);
	}

}