package com.lori.aspa.ui.utils;

public class StringUtil {

	public static boolean isValid(String value)
	{
		return value != null && !"".equals(value.trim());
	}
	
	public static String toUpper(String value)
	{
		if(!isValid(value)) return null;
		return value.trim().toUpperCase();
	}
	
	public static String formatSQ(String value)
	{
		if(isValid(value))
		{
			return value.trim().toUpperCase().replace("Ë","E").replace("Ç", "C");
		}
		return null;
	}
}
