package com.example.refactoring;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import com.example.refactoring.DeliveryDate;

class DeliveryDateTest {

	@Test
	//void _配送日のテスト() {
	void _小の月の月末になる場合のテスト() {
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2020,9,13));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2020,9,30),actualDate);
	}

	@Test
	void _大の月の月末になる場合のテスト() {
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2020,10,13));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2020,10,31),actualDate);
	}

}


class FakeDeliveryDate extends DeliveryDate {
	private LocalDate date;
	@Override
	protected LocalDate getNow() {return date;}
	public void setDate(LocalDate date) { this.date = date; }
}