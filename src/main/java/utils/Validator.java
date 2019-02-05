package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static void main(String[] args) {
		
		List<String> l = new ArrayList<String>();
		System.out.println(l);
		
		Vector v= new Vector<>();
		v.add("s");
		System.out.println(v);
		
		String text = "/user/bin/bash/filename_123.txt";
		String regex = "[\\d | \\w]+.txt";
		Pattern pattern = Pattern.compile(regex);
		 Matcher foudn = pattern.matcher(text);
		while (foudn.find()){
			System.out.println(foudn.start() + " " + foudn.end());
			System.out.println(text.substring(foudn.start(), foudn.end()));
		}
	}
	
	public static boolean isEmail(String email){
		return Pattern.matches("[\\w][\\w|\\d|.|_|-]+[@][\\w]+[\\.][\\w]+", email);
	}
	
	public static boolean isMobileNumber(String number){
		return Pattern.matches("[+]{0,1}[\\d]{0,2}[\\s]{0,1}[\\d]{10}", number);
	}
	
	public static boolean isIPAddress(String ip){
		return Pattern.matches("[\\d]{0,3}[\\.][\\d]{0,3}[\\.][\\d]{0,3}[\\.][\\d]{0,3}", ip);
	}
	
	public static boolean isNumberData(String number){
		return Pattern.matches("[\\d]+", number);
	}
	
	public static boolean isAlphaNumeric(String string){
		return Pattern.matches("[\\w]+", string);
	}
	
	
}
