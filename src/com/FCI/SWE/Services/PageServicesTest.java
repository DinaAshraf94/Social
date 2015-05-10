package com.FCI.SWE.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.core.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mortbay.util.ajax.JSON;

import com.FCI.SWE.Controller.Connection;
import com.FCI.SWE.Models.PageEntity;
import com.FCI.SWE.Models.PostEntity;
import com.FCI.SWE.Models.User;
import com.FCI.SWE.Models.UserEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class PageServicesTest 
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
  public void createGroup()
  {
	  	String serviceUrl = "http://localhost:8888/rest/Search4PageService/";
		String urlParameters = "name="+"d";
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

  @Test
  public void createPage() 
  {
	  	String serviceUrl = "http://localhost:8888/rest/CreatePageService";
		String urlParameters = "owner=" + "d"
				+ "&name=" + "AyaFood" + "&type=" + "Food" + "&category=" + "Food";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		
		JSONParser parser = new JSONParser();
		Object obj;
		try 
		{
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals("OK", object.get("Status"));
			
			//if (object.get("Status").equals("OK"))
			//return "Page created Successfully.";
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void likePage() 
  {
	  	String serviceUrl = "http://localhost:8888/rest/likePageService/";
		String urlParameters = "userEmail=" + "d" + "&pageName="+"RanaFood";
		System.out.println("urlParameters: " + urlParameters);
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");

		System.out.println(retJson);
		
		JSONParser parser = new JSONParser();
		Object obj;
		
		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals(object.get("Status"), "OK");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void viewPage() 
  {
	  String serviceUrl = "http://localhost:8888/rest/viewPageService/";
	    String urlParameters = "userEmail=" + "d" + "&pageNameView="+"RanaFood1";
	    System.out.println("urlParameters: " + urlParameters);
	    String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");

	    System.out.println("retJson" + retJson);
	    
	    Map <String, Vector<PostEntity>> passedPosts = new HashMap <String, Vector<PostEntity>> ();
	    
	    JSONParser parser = new JSONParser();
	    //Object obj = new Object();
	    
	    try {
	    		
			JSONArray array = (JSONArray)parser.parse(retJson);
			Assert.assertNotNull(array);
			
	

	    } catch (ParseException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

    //throw new RuntimeException("Test not implemented");
  }
}
