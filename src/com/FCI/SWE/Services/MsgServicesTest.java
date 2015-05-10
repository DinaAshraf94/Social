package com.FCI.SWE.Services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.Connection;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class MsgServicesTest {

LocalServiceTestHelper service = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	
	@BeforeClass
	public void setUp()
	{
		service.setUp();
	}
	@AfterClass
	public void tearDown(){
		service.tearDown();
	}


  @Test
  public void sendMsg() 
  {
	  String serviceUrl = "http://localhost:8888/rest/SendMsg";
		String urlParameters = "cname="+"girlsTalks"+"&content="+"hi"+"&email="+"d"; 
		MsgServices.selected.add("S");
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
	
		
		
		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals(object.get("response"),"msg is sent");
				
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
    //throw new RuntimeException("Test not implemented");
  }

 
 
}
