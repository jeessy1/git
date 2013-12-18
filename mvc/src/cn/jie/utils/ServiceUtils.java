package cn.jie.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.mail.util.BASE64EncoderStream;


public class ServiceUtils {
	public static String md5(String message){
		
//		MessageDigest md;
//		try {
//			md = MessageDigest.getInstance("md5");
//			byte md5[] = md.digest(message.getBytes());
//			Base64 
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;

		        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		                'a', 'b', 'c', 'd', 'e', 'f'};
		        try {
		            byte[] strTemp = message.getBytes();
		            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		            mdTemp.update(strTemp);
		            byte[] md = mdTemp.digest();
		            int j = md.length;
		            char str[] = new char[j * 2];
		            int k = 0;
		            for (int i = 0; i < j; i++) {
		                byte byte0 = md[i];
		                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
		                str[k++] = hexDigits[byte0 & 0xf];
		            }
		            String dd = new String(str);
		            return dd;
		        } catch (Exception e) {
		            return null;
		        }
		    }
}

