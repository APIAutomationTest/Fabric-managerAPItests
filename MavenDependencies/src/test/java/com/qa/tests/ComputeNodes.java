package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class ComputeNodes extends TestBase {
	private static String url =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_computeNodes");
	
	private static RestClient restClient = new RestClient();
	
	@Test
	public void get() throws ClientProtocolException, IOException {
		JSONObject response = super.get(ComputeNodes.url);
		// do other assertions
	
	
		
		// get value from JSON path 

		String id =TestUtil.getValueByJPath(response, "/items[0]/id");
		String locationId =TestUtil.getValueByJPath(response, "/items[0]/locationId");
		String name =TestUtil.getValueByJPath(response, "/items[0]/name");


		System.out.println(id);
		System.out.println(locationId);
		System.out.println(name);
		
		System.out.println("---------------------------------------------------------------------------------------------");
		
	
	
	}
}
