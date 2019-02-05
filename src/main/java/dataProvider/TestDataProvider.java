package dataProvider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import dataProvider.ExcelReader;


public class TestDataProvider {

	
	@DataProvider(name = "excelLoader")
	public static Object[][] createData(Method m) {
	    ExcelReader dh = new ExcelReader(m.getAnnotation(DataFilter.class).fileName());
	    Object[][] data = null;
	    String sheet = m.getAnnotation(DataFilter.class).sheetName();
	    if (sheet.isEmpty()){
	    	dh.setSheet(0);
	    }else{
	    	dh.setSheet(sheet);
	    }
	    if (sheet.isEmpty()){
	    	data = dh.getData(m.getAnnotation(DataFilter.class).filter());
	    }
	    return data;
	}
	
	@DataProvider(name = "csvReader")
	public static Object[][] csvReader(Method m){
		DataFilter cls = m.getAnnotation(DataFilter.class);
		CSVReader reader = new CSVReader(cls.fileName(), cls.seperator());
		List<HashMap<String, String>> map = reader.getCSVdata(true);
		int ROW= map.size();
		int COL= map.get(0).size();
	    Object[][] data = new Object[ROW][COL];
	    int i=0;int j=0;
	    for (HashMap<String, String> tmp: map){
	    	for (String s: tmp.keySet()){
	    		data[i][j] = s;
	    		j++;
	    	}
	    	i++;
	    }
	    return data;
	}
}
