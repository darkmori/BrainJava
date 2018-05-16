package com.jeong.bank;

class CheckingAccount extends Account {
	String cardNo;

	int pay(String cardNo, int amount) throws Exception {
		if (!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가합니다");
		return withdrow(amount);
	}
}
