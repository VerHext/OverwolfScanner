/**
 * 
 */
package de.verhext.overwolf.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author VerHext
 *
 * @project Overwolf_Query
 *
 * License:
 *
 * Copyright (C) 2017 VerHext <support@allesverhext.de>
 *
 * This work is licensed under the Creative Commons
 *
 * Attribution-NonCommercial-ShareAlike 4.0
 *
 * International License. To view a copy of this license,
 * visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */
public class Engine {

	public void log(int lvl,int type, String logMessage ){

		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        
        GregorianCalendar now = new GregorianCalendar();
        DateFormat dfg = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		
		String typeText = "ERROR";
		
		switch (type){
			case 1: typeText = "INFO"; break;
			case 2: typeText = "ERROR"; break;
			case 3: typeText = "SUPPORT"; break;
			case 4: typeText = "VERSION"; break;
		}
		
		System.out.println("[Overwolf] [ " + c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH)+ "/" +  c.get(Calendar.DAY_OF_MONTH) + " " + dfg.format(now.getTime()) +  " ]  "+ typeText + "  " + logMessage);
		
	}
	
}

