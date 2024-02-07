package com.example.refactoring;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import com.example.refactoring.DeliveryDate;

class DeliveryDateTest {
	@Test
	void _大の月の月末() {
		Integer ootukiList[] = {1,3,5,7,8,10,12};
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		for (Integer month: ootukiList){
			deliveryDate.setDate(LocalDate.of(2020,month,13));
			LocalDate actualDate = deliveryDate.getDeliveryDate();
			assertEquals(LocalDate.of(2020,month,31),actualDate);
		}
	}

	@Test
	void 小の月の月末() {
		Integer onotukiList[] = {4,6,9,11};
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		for (Integer month: onotukiList){
			deliveryDate.setDate(LocalDate.of(2020,month,13));
			LocalDate actualDate = deliveryDate.getDeliveryDate();
			assertEquals(LocalDate.of(2020,month,30),actualDate);
		}
	}

	@Test
	void  この荷物は来月に回すのか(){
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2020,7,27));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2020,8,31),actualDate);
	}

	@Test
	void うるう年な2月(){
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2020,1,25));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2020,2,29),actualDate);
	}

	@Test
	void うるう年じゃない2月(){
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2019,1,25));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2019,2,28),actualDate);
	}

	@Test
	void 年末(){
		FakeDeliveryDate deliveryDate = new FakeDeliveryDate();
		deliveryDate.setDate(LocalDate.of(2020,12,25));
		LocalDate actualDate = deliveryDate.getDeliveryDate();
		assertEquals(LocalDate.of(2021,1,31),actualDate);
	}

}


class FakeDeliveryDate extends DeliveryDate {
	private LocalDate date;
	@Override
	protected LocalDate getNow() {return date;}
	public void setDate(LocalDate date) { this.date = date; }
}