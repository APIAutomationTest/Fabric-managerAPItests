/*

package com.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class RoutingInstanceTest extends TestBase<RoutingInstances> {
	private static String url =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_routingInstances");
	
	@Test
	public void get() throws ClientProtocolException, IOException {
		RoutingInstances response = super.get(url);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}

	@Override
	protected Class<RoutingInstances> getResponseClass() {
		
		return RoutingInstances.class;
	}
}
*/