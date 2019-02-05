package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	
	public static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numbers = "1234567890";
	
	public static void main(String[] args) {

		List<String> test = generateRandomString("", 100);
		System.out.println(test);
		
		List<Object> list = Collections.synchronizedList(new ArrayList<>());
		
		synchronized (list) {
			
		}
		
	}

	public static List<String> generateRandomString(String pattern, int sequenceLength) {
		
		List<String> list = new ArrayList<>();
		String last = "";
		int len = 0;
		int dk = 8;
		for (int k = 0; k < sequenceLength; k++) {

			if (last.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				StringBuilder b = new StringBuilder();
				for (int i = 0; i < 4; i++) {
					sb.append(chars.charAt((int) Math.random()));
					b.append(numbers.charAt((int) Math.random()));
				}
				sb.append(b);
				sb.append(chars.charAt((int) Math.random()));
				list.add(sb.toString());
				last = sb.toString();

			} else {
				char lastChar = last.charAt(dk);
				while (lastChar == 'Z' || lastChar == '9' || lastChar == 'Z') {
					dk--;
					lastChar = last.charAt(dk);
				}
				StringBuilder sb1 = new StringBuilder();
				sb1.append(last.substring(0, dk));
				sb1.append((char) (last.charAt(dk) + 1));
				sb1.append(last.substring(dk + 1));
				list.add(sb1.toString());
				last = sb1.toString();
			}
			len = last.length();
		}
		return list;
	}
	
	public static String getRandomString(int len){
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < len; i++) {
			sb.append(chars.charAt((int) Math.random()));
		}
		return sb.toString();
	}
	
	public static String getRandomNumberString(int len){
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < len; i++) {
			sb.append(numbers.charAt((int) Math.random()));
		}
		return sb.toString();
	}
	
	public static String getRandomAlphaString(int len){
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < len; i++) {
			sb.append(numbers.concat(chars).charAt((int) Math.random()));
		}
		return sb.toString();
	}
}
