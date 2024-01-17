package com.example.refactoring;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

// コメントがないから何したいか全くわからない
// 月末定期便で25以降の注文は来月の月末に配送ってとこ?

// 配達日?
public class DeliveryDate {
	public LocalDate getDeliveryDate(){
		LocalDate localDate = LocalDate.now();
		int day = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();

//		System.out.println("localDate:" + localDate);
//		System.out.println("day:" + day);
//		System.out.println("month:" + month);
//		System.out.println("year:" + year);

		// この荷物は来月に回すのか?
		if (this.isItMoveToNextMonth(month,day)) { month.plus(1L); }

		// 月末の日付を撮ってる?
		if (this.isOnotuki(year,month)){
			return LocalDate.of(localDate.getYear(),localDate.getMonth(),30);
		}

		if(month.equals(Month.FEBRUARY)){
			return LocalDate.of(localDate.getYear(),localDate.getMonth(),this.EndofFebruary(year));
		}

		return LocalDate.of(localDate.getYear(),localDate.getMonth(),31);
	}

	private boolean isOnotuki(int year, Month month){
		Month onotukiList[] = {Month.APRIL,Month.JUNE,Month.SEPTEMBER,Month.NOVEMBER};
		return Arrays.asList(onotukiList).contains(month);
	}

	private boolean isItMoveToNextMonth(Month month, int day){
		// 25以降の荷物は来月運ぶ?
		if(day >= 25) return true ;
		//年末の荷物は来年へ
		if (month.equals(Month.DECEMBER) && day >= 20) return true ;

		return false ;
	}

	private int EndofFebruary(int year){
		if(year%4 == 0) return 29;
		return 28 ;
	}
}