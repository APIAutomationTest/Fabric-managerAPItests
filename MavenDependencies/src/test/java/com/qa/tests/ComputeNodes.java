package com.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class ComputeNodes extends TestBase {
	private static String url =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_computeNodes");
	
	@Test
	public void get() throws ClientProtocolException, IOException {
		JSONObject response = super.get(ComputeNodes.url);
		// do other assertions
		
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
}
