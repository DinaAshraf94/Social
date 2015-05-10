package com.FCI.SWE.Services;

import javax.ws.rs.core.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mortbay.util.ajax.JSON;

import com.FCI.SWE.Controller.Connection;
import com.FCI.SWE.Models.User;
import com.FCI.SWE.Models.UserEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;




public class notificationServiceTest 
{

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
  public void getAllNotifications()
  {

		String serviceUrl = "http://localhost:8888/rest/getAllNotifications/";
		String urlParameters = "currentUserEmail=" + "d";
		
		String retJson = Connection.connect(serviceUrl, urlParameters, "GET",
				"application/x-www-form-urlencoded;charset=UTF-8");
	  
		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals("ok", object.get("response").toString());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
   // throw new RuntimeException("Test not implemented");
  }

}
