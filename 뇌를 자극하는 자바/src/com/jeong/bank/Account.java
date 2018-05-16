package com.jeong.bank;

class Account {
	String accountNo;
	String ownerName;
	int balance;

	void deposit(int amount) {
		balance += amount;
	}

	int withdrow(int amount) throws Exception {
		if(balance<amount)
			throw new Exception("잔액이 부족합니다.");
		return amount;

	}

}
