/*
 * Purpose of this class is to record all the data from excel
 * there are setter/getter
 */

package utility;
public class dataRecord {
	private String testID;
	private String user;
	private String pass; 
	private String expectVal;
	
	public String getMethodName(){
		return testID; 
	}
	public String getUser(){
		return user;
	}
	public String getPass(){
		return pass;
	}
	public String getExpectedValue(){
		return expectVal;
	}
	
	//set setter
	public void setTestID(String id){
		this.testID = id;
	}
	public void setUser(String name){
		this.user = name;
	}
	public void setPass(String auth){
		this.pass = auth; 
	}
	public void setExpectedValue(String val){
		this.expectVal = val; 
	}
}
