package com.nt.enums;

public class EnumTest7 {
	public static void main(String[] args) {
		System.out.println(Beer7.KF.equals(Beer7.RC));
		System.out.println(Beer.KF.hashCode() > Beer7.RC.hashCode());
//		System.out.println(Beer7.KF < Beer7.RC);
		System.out.println(Beer7.KF.ordinal() < Beer7.RC.ordinal());
	}
}

enum Beer7{
	BW,RC,KO,SO,VK,KF; // these all are nothing but static objects only
}