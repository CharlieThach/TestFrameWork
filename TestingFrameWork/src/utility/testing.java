package utility;

import java.util.ArrayList;

public class testing {

	public static void main(String arg[]){
		
		ArrayList<dataRecord> rec = new ArrayList<dataRecord>(); 
		loadTestCases load = new loadTestCases();
		
		rec = load.readExcel(); 
		
		for(dataRecord a: rec){
			System.out.println(a.getMethodName()+"\t"+ a.getUser() +"\t"+a.getPass()+"\t"+a.getExpectedValue());
		}
		
		
	}
}
