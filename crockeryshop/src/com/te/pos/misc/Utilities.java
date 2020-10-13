package com.te.pos.misc;

public class Utilities {

	public static Long getLongObject(String value) {
		Long result=null;
		try {
			result=Long.parseLong(value);
		}catch(Exception e) {
		}
		return result;
	}
	
	
}
