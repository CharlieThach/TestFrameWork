package utility;

import java.util.ArrayList;

public class testing {

	public static void main(String arg[]){
		
		ArrayList<Record> rec = new ArrayList<Record>(); 
		loadTestCases load = new loadTestCases();
		
		rec = load.readExcel(); 
		
		for(Record a: rec){
			System.out.println(a.getMethodName()+"\t"+ a.getUser() +"\t"+a.getPass()+"\t"+a.getExpectedValue());
		}
		
		
	}
}
