package dataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import utils.Logging;
import utils.ResourceProvider;

public class CSVReader {
	private Logger log = Logging.getLogger(getClass());
	static BufferedReader br = null;
	private static List<String> headers = new ArrayList<String>();
	static String seperator = " ";

	/**
	 * use this if file contains firstLine as header fields
	 * 
	 * @param filename
	 */
	public CSVReader(String filename, String seperator) {
		CSVReader.seperator = seperator;
		log.info("Setting Field seperator to : '" + seperator + "'");
		readFile(new ResourceProvider().getResource(filename), true);
	}

	public CSVReader(String filename, String seperator, String... fields) {
		CSVReader.seperator = seperator;
		for (String field : fields) {
			headers.add(field);
		}
		readFile(new ResourceProvider().getResource(filename), false);
	}

	private void readFile(String filename, boolean header) {
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			if (header) {
				try {
					String head = br.readLine();
					String[] fields = head.split(seperator);
					for (String f : fields) {
						headers.add(f.trim());
					}
				} catch (IOException e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error(e);
		}
	}

	public static List<HashMap<String, String>> getCsvData() {
		List<HashMap<String, String>> data = new LinkedList<HashMap<String, String>>();
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			String s[] = line.split(seperator);
			if (s.length != headers.size()) {
				System.out.println("Fields length and Header Length Misamtch");
			} else {
				for (int i = 0; i < s.length; i++) {
					map.put(headers.get(i), s[i]);
				}
			}
			data.add(map);
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public List<HashMap<String, String>> getCSVdata(boolean header){
		boolean flag = header;
		List<HashMap<String, String>> data = new LinkedList<HashMap<String, String>>();
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			HashMap<String, String> map = new HashMap<String, String>();
			String s[] = line.split(seperator);
			if (flag) {
				headers.clear();
				for (String f : s) {
					headers.add(f.trim());
					flag = false;
				}
			} else {
				for (int i = 0; i < s.length; i++) {
					map.put(headers.get(i), s[i]);
				}
			}
			data.add(map);
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
		
	}
}
