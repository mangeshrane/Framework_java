package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utils.Logging;

public class ExcelReader {

	private Logger log = Logging.getLogger(getClass());

	private Workbook workbook;
	private Sheet sheet;

	public ExcelReader(String FileName) {
		String FilePath = getClass().getClassLoader().getResource(FileName).getFile();
		log.info("Fetching fileName: " + FileName + " getting file path: " + FilePath);
		try {
			FileInputStream fis = new FileInputStream(new File(FilePath));
			if (FileName.endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			} else if (FileName.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else {
				log.error("File should be xls or xlsx");
			}
			log.info("Workbook Created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ExcelReader setSheet(int sheetNumber) {
		sheet = workbook.getSheetAt(sheetNumber);
		log.info("Getting sheet at " + sheetNumber + "Number");
		return this;
	}

	public ExcelReader setSheet(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		log.info("Getting sheet with name: " + sheetName);
		return this;
	}

	public String[][] getData(String filter) {

		List<Object[]> data = new ArrayList<>();
		String[][] tabArray = null;
		int rows = sheet.getLastRowNum() + 1;
		log.info("Number of Rows in excel sheet " + rows);
		boolean Flag = false;
		int START = 0;

		int ROW = 0;
		int COL = 0;
		for (int i = 0; i < rows; i++) {
			log.info("i " + i);
			if (sheet.getRow(i).getCell(0) != null) {

				log.info("FILTER : " + sheet.getRow(i).getCell(0).getStringCellValue());
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(filter)) {
					Flag = true;
					START = i + 1;
					log.info("last cell no " + sheet.getRow(i + 1).getLastCellNum());
					COL = sheet.getRow(i + 1).getLastCellNum();

				}

				if (Flag) {
					ROW++;
				}

				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("end")) {
					log.info("IN TRAP");
					Flag = false;
					break;
				}
			}
		}

		tabArray = new String[ROW + 1][COL];
		int k = 0;
		log.info("ROW : " + ROW + "COL: " + COL + " START " + START);
		for (int i = START; i <= START + ROW; i++) {
			int l =0;
			for (int col = 1; col < sheet.getRow(i).getLastCellNum(); col++) {
				DataFormatter formatter = new DataFormatter();
				String val = formatter.formatCellValue(sheet.getRow(i).getCell(col));
				tabArray[k][l] = val;
				l++;
			}
			k++;
		}
		return tabArray;

	}

	public List<Map<String, String>> getDataWithHeader(String filter) {
		List<Map<String, String>> data = new ArrayList<>();
		List<String> list = new LinkedList<>();
		int rows = sheet.getLastRowNum();
		log.info("Number of Rows in excel sheet " + rows);
		boolean Flag = false;

		for (int i = 0; i < rows; i++) {
			if (sheet.getRow(i).getCell(0) != null) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(filter)) {
					Flag = true;
					log.info("last cell no " + sheet.getRow(i + 1).getLastCellNum());
					for (int k = 1; k < sheet.getRow(i + 1).getLastCellNum(); k++) {
						log.info("cell value " + sheet.getRow(i + 1).getCell(k).getStringCellValue());
						list.add(sheet.getRow(i + 1).getCell(k).getStringCellValue());
					}
				} else if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("END")) {
					Flag = false;
					list.clear();
				}
			}
			if (Flag) {
				List<String> tmp = new LinkedList<>();
				Map<String, String> map = new HashMap<>();
				if (i + 2 > rows) {
					break;
				}

				for (int col = 1; col < sheet.getRow(i + 2).getLastCellNum(); col++) {
					log.info("CELL VALUE :" + sheet.getRow(i + 2).getCell(col));
					DataFormatter formatter = new DataFormatter();
					String val = formatter.formatCellValue(sheet.getRow(i + 2).getCell(col));
					tmp.add(val);
				}
				log.info("TMP: " + tmp);
				log.info("LIST : " + list);
				log.info("list size : " + list.size() + "tmp size : " + tmp.size());
				if (tmp.size() < 1) {
					break;
				}
				for (int t = 0; t < list.size(); t++) {
					map.put(list.get(t), tmp.get(t));
				}
				data.add(map);
			} else {
				break;
			}
		}
		return data;
	}

}
