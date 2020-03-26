package com.cy.pj.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class newDateUtils {
	public static String newDate(Date createdtime) {
		SimpleDateFormat dateFormat = new 
				SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newDate = dateFormat.format(createdtime);
		return newDate;
	}

}
