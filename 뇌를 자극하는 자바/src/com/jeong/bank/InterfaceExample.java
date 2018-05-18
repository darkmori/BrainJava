package com.jeong.bank;

public class InterfaceExample {

	public static void main(String[] args) {
		// SeparateVolume obj1 = new SeparateVolume("863?774개", "개미", "베르나르 베르베르");
		// AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
		// obj1.checkOut("김영숙", "20180508");
		// obj2.checkOut("박희경", "20180515");
		// obj1.checkIn();
		// obj2.checkIn();

		Landable obj = new SeparateVolume("863?774개", "개미", "베르나르 베르베르");
		obj.checkOut("김영숙", "20180508");
		obj.checkIn();

		obj = new AppCDInfo("2005-7001", "Redhat Fedora");
		obj.checkOut("박희경", "20180515");
		obj.checkIn();
	}

}
