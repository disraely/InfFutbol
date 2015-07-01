package Utilities;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class Utilities {

	public static Date getToday() {
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        return sqlDate;
    }
	
	public static Date stringToDate(String fecha) throws ParseException{
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		format.setTimeZone(TimeZone.getTimeZone("America/Lima"));

		java.util.Date date = format.parse(fecha);

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		return sqlDate;
	}
	
	public static int stringToInt(String strNum){
		int num;
		num = Integer.parseInt(strNum);
		return num;
	}
	
	public static String getFileExtension(String name) {
		try {
			return name.substring(name.lastIndexOf("."));
	    } catch (Exception e) {
	        return "";
	    }
	}
	
}
