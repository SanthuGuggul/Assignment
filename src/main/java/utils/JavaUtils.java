package utils;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.testng.Assert;

public class JavaUtils {
	
	public static HashMap<String, String> configProperties = new HashMap<String, String>();
	
	public HashMap<String, String> readConfigProperties() {
		String sectionName = null;
		Set<Entry<String, String>> dataSet;
		Ini ini;
		try {
			ini = new Ini(new File("./config.ini"));
		

			Ini.Section section = ini.get("Common");
			dataSet = section.entrySet();

			sectionName = section.get("configName");
			section = ini.get(sectionName);

			dataSet.addAll(section.entrySet());
			for (Map.Entry<String, String> set : dataSet) {
				configProperties.put(set.getKey().toString(), set.getValue().toString());
			}
			System.out.println(configProperties.entrySet());
			return configProperties;
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void main(String[] args) {
		JavaUtils ju=new JavaUtils();
		ju.readConfigProperties();
	}
	
	public void addConfigToIni(String key, String value) {
		try {
			Ini ini = new Ini(new File("./config.ini"));
			ini.put("Common", key, value);
			ini.store();
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getvalueFromIni(String name) {
		Ini ini;
		try {
			ini = new Ini(new File("./testData.ini"));
			return ini.get("Common", name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String setvalueToIni(String user,String value) {
		Ini ini;
		try {
			ini = new Ini(new File("./testData.ini"));
			ini.put("Common",user, value);
			ini.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public HashMap<String, String> readExcelData(String workbook, String sheetname, String uniqueValue) {
		try {
			String key, value;
			FileInputStream file = new FileInputStream(configProperties.get(workbook));
			HashMap<String, String> dataMap = new HashMap<String, String>();
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet(sheetname);
			Iterator<Row> it = sheet.rowIterator();

			Row headers = it.next();
			while (it.hasNext()) {

				Row record = it.next();
				String cellValue = record.getCell(0).toString().trim();
				if (cellValue.equalsIgnoreCase(uniqueValue)) {

					for (int i = 0; i < headers.getLastCellNum(); i++) {
						if ((null != record.getCell(i))
								&& (record.getCell(i).getCellType() == record.getCell(i).CELL_TYPE_NUMERIC)) {
							if (HSSFDateUtil.isCellDateFormatted(record.getCell(i))) {

								DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

								value = dateFormat.format(record.getCell(i).getDateCellValue()).trim();

							} else {
								record.getCell(i).setCellType(Cell.CELL_TYPE_STRING);

								value = record.getCell(i).toString().trim();
							}
							key = headers.getCell(i).toString().trim();

						} else {

							key = (headers.getCell(i) + "".toString()).trim() + "";
							value = (null != record.getCell(i)) ? (record.getCell(i) + "".toString()).trim() + "" : "";
						}
						dataMap.put(key, value);
					}
					break;
				}
			}
			return dataMap;
		} catch (NullPointerException e) {
			throw new NullPointerException("Failed due to NullPointerException" + e);
		} catch (EncryptedDocumentException e) {
			throw new EncryptedDocumentException("Failed due to EncryptedDocumentException" + e);
		} catch (InvalidFormatException e) {
			throw new NullPointerException("Failed due to InvalidFormatException" + e);
		} catch (IOException e) {
			throw new NullPointerException("Failed due to IOException" + e);
		}
	}
	
	public List<HashMap<String, String>> returnRowsUniqueValueBasedOnTestTypeList(String workbookName, String sheetName,
			String testType) {

		HashMap<String, String> dataMap = new HashMap<String, String>();
		List<HashMap<String, String>> allValues = new ArrayList<HashMap<String, String>>();
		try {
			FileInputStream file = new FileInputStream(configProperties.get(workbookName));
			if (file != null) {
				System.out.println();
			}
			System.out.println(configProperties.get(workbookName));
			String key, value;
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet(sheetName);
			boolean flag = false;
			Iterator<Row> it = sheet.rowIterator();
			int i = 0;
			Row headers = it.next();
			while (it.hasNext()) {

				Row record = it.next();

				if ((record.getCell(3).toString().trim() + "").equalsIgnoreCase("yes")) {
					if (testType.equalsIgnoreCase("no-check")) {
						flag = true;
					} else if ((record.getCell(1).toString().trim() + "").equalsIgnoreCase(testType)) {
						flag = true;
					}

				}
				if (flag == true) {
					for (i = 0; i < headers.getLastCellNum(); i++) {
						if ((null != record.getCell(i))
								&& (record.getCell(i).getCellType() == record.getCell(i).CELL_TYPE_NUMERIC)) {
							if (HSSFDateUtil.isCellDateFormatted(record.getCell(i))) {

								DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

								value = dateFormat.format(record.getCell(i).getDateCellValue()).trim();

							} else {
								record.getCell(i).setCellType(Cell.CELL_TYPE_STRING);

								value = record.getCell(i).toString().trim();
							}
							key = headers.getCell(i).toString().trim();

						} else {

							key = (headers.getCell(i) + "".toString()).trim() + "";
							value = (null != record.getCell(i)) ? (record.getCell(i) + "".toString()).trim() + "" : "";
						}
						dataMap.put(key, value);
//						System.out.println(key+" : "+value);
					}
					allValues.add(dataMap);
					dataMap = new HashMap<String, String>();
					
				}
				flag = false;
			}

			return allValues;

		} catch (NullPointerException e) {
			throw new NullPointerException("Failed due to NullPointerException" + e);
		} catch (EncryptedDocumentException e) {
			throw new EncryptedDocumentException("Failed due to EncryptedDocumentException" + e);
		} catch (InvalidFormatException e) {
			throw new NullPointerException("Failed due to InvalidFormatException" + e);
		} catch (IOException e) {
			throw new NullPointerException("Failed due to IOException" + e);
		}

	}
	public Object[][] returnAllUniqueValuesInMap(String workbookName, String sheetName, String testType) {

		List<HashMap<String, String>> listValues = returnRowsUniqueValueBasedOnTestTypeList(workbookName, sheetName,
				testType);

		Object[][] allValues = new Object[listValues.size()][1];

		for (int i = 0; i < listValues.size(); i++) {
			allValues[i][0] = listValues.get(i);

		}
		return allValues;
	}
	
	public String generateRandomAlphaString(int count) {
	return  RandomStringUtils.randomAlphabetic(count);
	}
	
	public String generateRandomNumber(int count) {

		return RandomStringUtils.randomNumeric(count);

	}
	
	
	
	public void assertOnResponse(String Expected,String Actual) {
		
      Assert.assertEquals(Expected,Actual);
     System.out.println("Assertion on " +Expected+" is successful");
			
		
		
	}
	
	
	public void assertOnDoubleTypeResponse(Double Expected,Double Actual) {
		
	      Assert.assertEquals(Expected,Actual);
	     System.out.println("Assertion on " +Expected+" is successful");
				
			
			
		}
	

	

}
