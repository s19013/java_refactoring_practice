package com.example.refactoring;

import java.time.LocalDate;
import java.time.Month;

public class DeliveryDate {
	public LocalDate getDeliveryDate(){
		LocalDate localDate = LocalDate.now();
		int day = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();

		if(day >= 25){
			month.plus(1L);
		} else if (month.equals(Month.DECEMBER) && day >= 20) {
			month.plus(1L);
		}

		int lastDay;
		if(month.equals(Month.APRIL)) {
			lastDay = 30;
		} else if(month.equals(Month.JUNE)){
			lastDay = 30;
		} else if(month.equals(Month.SEPTEMBER)){
			lastDay = 30;
		} else if(month.equals(Month.NOVEMBER)){
			lastDay = 30;
		} else if(month.equals(Month.FEBRUARY)){
			if(year%4 == 0){
				lastDay = 29;
			} else {
				lastDay = 28;
			}
		} else {
			lastDay = 31;
		}
		return LocalDate.of(localDate.getYear(),localDate.getMonth(), lastDay);
	}
}