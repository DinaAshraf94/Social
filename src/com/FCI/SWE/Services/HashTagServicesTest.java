package com.FCI.SWE.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.Connection;
import com.FCI.SWE.Models.HashTagEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class HashTagServicesTest 
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
  public void createHashtag() 
  {
	  String serviceUrl = "http://localhost:8888/rest/Search4HashTag/";
		String urlParameters = "name="+"hello";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
		
		JSONParser parser = new JSONParser();
		
		try 
		{
			
			JSONArray array = (JSONArray)parser.parse(retJson);
			Assert.assertNotNull(array);
			
			
		} catch (ParseException e){
			e.printStackTrace();
		}
		

		

    //throw new RuntimeException("Test not implemented");
  }
}
