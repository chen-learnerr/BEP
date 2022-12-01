package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;

public class Tools {
	public boolean strCheck(String str) {
		if(str != null && !str.equals("")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String MD5(String oldStr) {
		byte[] oldBytes=oldStr.getBytes();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] newBytes = md.digest(oldBytes);
			Encoder encoder= Base64.getEncoder();
			String newStr = encoder.encodeToString(newBytes);
			return newStr;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}	
	}
	
	public static Date addDate(Date date, long day) throws ParseException {
		 long time = date.getTime(); // 得到指定日期的毫秒数
		 day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		 time+=day; // 相加得到新的毫秒数
		 return new Date(time); // 将毫秒数转换成日期
	}
}
