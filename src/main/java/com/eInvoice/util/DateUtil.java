package com.eInvoice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String sqlFormatterDate(String date) throws ParseException
	{
		if(date != null && !date.isEmpty()) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date parsedDate = formatter.parse(date);
			formatter.applyPattern("yyyy-MM-dd");
			return formatter.format(parsedDate);
		}else {
			return "";
		}
	}
}
