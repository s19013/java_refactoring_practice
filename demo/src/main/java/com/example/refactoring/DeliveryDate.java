package com.example.refactoring;

import java.time.temporal.TemporalAdjusters;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

// コメントがないから何したいか全くわからない
// 月末定期便で25以降の注文は来月の月末に配送ってとこ?

// 配達日?
public class DeliveryDate {
	public LocalDate getDeliveryDate(){
		LocalDate localDate = this.getNow();
		int day = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();

		// この荷物は来月に回すのか?
		if (this.isItMoveToNextMonth(month,day)) {localDate = localDate.plusMonths(1);}

		return localDate.with(TemporalAdjusters.lastDayOfMonth());
	}

	private boolean isItMoveToNextMonth(Month month, int day){
		// 25以降の荷物は来月運ぶ?
		if(day >= 25) return true ;
		//年末の荷物は来年へ
		if (month.equals(Month.DECEMBER) && day >= 20) return true;

		return false ;
	}

//	テストで上書きするため
	protected LocalDate getNow(){
		return LocalDate.now();
	}
}