package com.beltonp.phil.budget.helpers;

import android.content.Context;

import java.util.LinkedHashMap;

public class StringHelper
{
	public static LinkedHashMap<String, String> getMapFromStringArray(Context context, int arrayId)
	{
		String[] array = context.getResources().getStringArray(arrayId);
		LinkedHashMap<String, String> result = new LinkedHashMap<>();
		for (String str : array)
		{
			String[] splittedItem = str.split("\\|");
			result.put(splittedItem[0], splittedItem[1]);
		}
		return result;
	}
}
