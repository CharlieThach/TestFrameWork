package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class loadTestCases {
	
	String filePath;
	FileInputStream fs ;
	Sheet sh; 
	Workbook wb; 
	int numOfRow;
	int numOfCol; 
	ArrayList<Record> arrRec; 

	loadTestCases(){
		filePath = "src/testCase/booktest.xls";
		numOfRow = 0;
		numOfCol = 0; 
		arrRec = new ArrayList<Record>(); 
	}

	public ArrayList<Record> readExcel(){
	 	
		try {
			fs = new FileInputStream(filePath);
			wb = Workbook.getWorkbook(fs);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open the file");
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh = wb.getSheet("Sheet1");
		numOfRow = sh.getRows();
		numOfCol = sh.getColumns(); 
			for( int i = 1; i < numOfRow; i++){
				Record rec = new Record(); //add data into the arraylist 
				
				for(int j = 0; i< numOfCol; j++){
				
					switch (j){
					case 0://testID
						//rec.setTestID((sh.getCell(i, j)).toString());
						System.out.println((sh.getCell(j, i).getContents()));
						break;
					case 1: //user
						rec.setUser((sh.getCell(i, j)).toString());
						System.out.println((sh.getCell(j, i).getContents()));
						break;
					case 2: //password
						System.out.println((sh.getCell(j, i).getContents()));
						rec.setPass((sh.getCell(j, i).getContents()));
						break;
					case 3: //expected value
						System.out.println((sh.getCell(j, i).getContents()));
						rec.setExpectedValue((sh.getCell(j, i).getContents()));
						break;
					}
				}
				arrRec.add(rec);
			}
		
		return arrRec; 
	}
}
