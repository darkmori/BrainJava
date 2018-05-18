package com.jeong.bank;

public interface Landable {
	// 추상메소드
	abstract void checkOut(String borrwer, String date);

	abstract void checkIn();
}
