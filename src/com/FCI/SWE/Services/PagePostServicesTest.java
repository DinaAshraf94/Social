package com.FCI.SWE.Services;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.Connection;
import com.FCI.SWE.Models.PageEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class PagePostServicesTest {



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
  public void createPostServicePage() 
  {
	  String serviceUrl = "http://localhost:8888/rest/CreatePostPage";
		String urlParameters = "postContent=" + "hello everyone" + "&writerEmail="
				+ "RanaFood" + "&privacy=" + "public" + "&postPlace="
				+ "RanaFood" + "&Feelings=" + "";
		String result = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		Assert.assertEquals(result, "postCreated");
	//	if (result.equals("postCreated"))
	
   // throw new RuntimeException("Test not implemented");
  }
}
