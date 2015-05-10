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

public class ServiceTest 
{
	UserEntity user = new UserEntity("dina", "dina", "123");
	UserEntity user2 = new UserEntity("d", "d", "123");
	UserEntity user3 = new UserEntity("S", "S", "123");
	UserEntity user4 = new UserEntity("A", "A", "123");
	UserEntity user5 = new UserEntity("R", "R", "123");
	

	LocalServiceTestHelper service = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	
	@BeforeClass
	public void setUp()
	{
		service.setUp();
		user.saveUser();
		user2.saveUser();
		user3.saveUser();
		user4.saveUser();
		user5.saveUser();
	//	UserEntity.addFriendRequestIDsFromAndTo(user2.getEmail(), user.getEmail());
	//	UserEntity.addFriendRequestIDsFromAndTo(user3.getEmail(), user.getEmail());
	//	UserEntity.addFriendRequestIDsFromAndTo(user4.getEmail(), user.getEmail());
		//UserEntity.checkAcceptTable(user2.getEmail(),user.getEmail());
		
	}
	@AfterClass
	public void tearDown(){
		service.tearDown();
	}
  @Test
  public void AcceptRequest() 
  {
	  	String serviceUrl = "http://localhost:8888/rest/accept";
		String urlParameters = "friendEmail=" + "d" + "&MyEmail="+"S";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
		
		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals("request accepted", object.get("response").toString());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
	  //   throw new RuntimeException("Test not implemented");
  }

  @Test
  public void RequestAlreadySent() 
  {
	  	String serviceUrl = "http://localhost:8888/rest/RequestAlreadySent";		
		String urlParameters = "friendEmail=" + "S" + "&senderEmail="+"d";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
		
		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals(object.get("response"),"request is sent" );
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  
   // throw new RuntimeException("Test not implemented");
  }

  @Test
  public void loginService()
  {
	  
	  	String serviceUrl = "http://localhost:8888/rest/LoginService";
		String urlParameters = "email=" + "d" + "&password=" + "123";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");

		System.out.print("here ! ");
		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			System.out.print("hello "+object.get("Status"));
			Assert.assertEquals("OK", object.get("Status").toString());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		/*********************************************************************************/
		/*

	  	String serviceUrl1 = "http://localhost:8888/rest/LoginService";
		String urlParameters1 = "email=" + "R" + "&password=" + "123";
		String retJson1 = Connection.connect(serviceUrl1, urlParameters1, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
		

		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson1);
			JSONObject object = (JSONObject) obj;
			System.out.print("hello!");
			 Assert.assertEquals("OK", object.get("Status").toString());
			 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		/************************************************************************/

 
			//Assert.assertNotNull(user1);
  }
	 

  @Test
  public void registrationService()
  {
	  
		String serviceUrl = "http://localhost:8888/rest/RegistrationService";
		String urlParameters = "uname=" + "dina11" + "&email=" + "dina11" + "&password=" + "123";
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST", "application/x-www-form-urlencoded;charset=UTF-8");
		
		try 
		{

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			Assert.assertEquals("OK", object.get("Status").toString());

		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  @Test
  public void search() 
  {
    //throw new RuntimeException("Test not implemented");
  }
}
