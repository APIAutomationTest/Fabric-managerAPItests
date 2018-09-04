package com.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class NetworkPlaneTest extends TestBase<NetworkPlanes, Object> {
	public NetworkPlaneTest() {
		super(NetworkPlanes.class, Object.class);
	}

	private static String url =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_networkPlanes");
	
	@Test
	public void get() throws ClientProtocolException, IOException {
		NetworkPlanes response = super.get(url);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
}
