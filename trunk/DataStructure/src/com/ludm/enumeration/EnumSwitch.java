package com.ludm.enumeration;

public class EnumSwitch {

	public static void main(String[] args) {
		
		EnumConstants constants = EnumConstants.A;
		switch (constants) {

		case A:
			System.out.println(EnumConstants.A);
			break;
		case B:
			System.out.println(EnumConstants.B);
			break;
		case C:
			System.out.println(EnumConstants.C);
			break;
		case D:
			System.out.println(EnumConstants.D);
			break;
		default :
			System.out.println("Default");
		}
	}
}
