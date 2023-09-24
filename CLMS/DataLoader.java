package CLMS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLoader {

	static String company;
	static int shipID;
	static String name;
	static String location;
	static String origin;
	static String destination;
	static String[] itinerary = new String[19];
	static int tripLength; 
	static int numCabins;
	static int yearOfBuild;
	static int maintance;
	static int maxCapacity;

	static String filename = "C:/Users/djclo/OneDrive/Desktop/School/CMSC_495/Group3/CLMS_database.xlsx";

	public static void main(String[] args) throws IOException {
		Loadship(1);
	}

	public static void Loadship(int i) throws IOException {
		// Creating a xls file object with specific file path to read
		File xlsFile = new File(filename);
		// Creating input stream
		FileInputStream inputStream = new FileInputStream(xlsFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		// Reading the first sheet of the excel file
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(i+1);  
		Iterator<Cell> cellIterator = row.iterator();
		// Iterating all the columns in a row
		int colNum = 0;    
		while (cellIterator.hasNext()) {
			int z = 0;
			Cell cell = cellIterator.next();
			switch (colNum) {
			case 0:
				company = cell.getRichStringCellValue().getString();
				System.out.println(colNum+ " " + company);
				break;
			case 1:
				name = cell.getRichStringCellValue().getString();
				System.out.println(colNum+ " " + name);
				break;
			case 2:
				shipID = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + shipID);
				break;
			case 3:
				location = cell.getRichStringCellValue().getString();
				System.out.println(colNum+ " " + location);
				break;
			case 4:
				tripLength = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + tripLength);
				break;
			case 5:
				numCabins = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + numCabins);
				break;
			case 6:
				yearOfBuild = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + yearOfBuild);
				break;
			case 7:
				maintance = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + maintance);
				break;
			case 8:
				maxCapacity = (int) cell.getNumericCellValue();
				System.out.println(colNum+ " " + maxCapacity);
				break;
			case 9:
				origin = cell.getRichStringCellValue().getString();
				System.out.println(colNum+ " " + origin);
				break;
			case 10:
				destination = cell.getRichStringCellValue().getString();
				System.out.println(colNum+ " " + destination);
			default:
				String travelSpot = cell.getRichStringCellValue().getString();
				if (!travelSpot.isBlank()) 
				{
					itinerary[z] = travelSpot;
					System.out.println(colNum+ " " + travelSpot); 
					z++;
				}else {
					System.out.println(colNum+ " ");
				}
				break;
			}
			colNum++;

		}
		
		// Closing the workbook and input stream

		workbook.close();
		inputStream.close();
	}

}
