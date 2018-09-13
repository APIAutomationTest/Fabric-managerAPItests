package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.base.TestHelper;

public class SubnetsTest extends TestBase<Subnets, Object> {
	public SubnetsTest() {
		super(Subnets.class, Object.class);
	}	private static String SubnetsNeworkID =
		TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_SubnetsNeworkID");
	private static String Subnets =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_Subnets");
		
	
	
	
	
	@Test
	public void getSubnetsNetworkID() throws ClientProtocolException, IOException {
		Subnets response = super.get(SubnetsNeworkID);
		// do other assertions
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		System.out.println("---------------------------------------------------------------------------------------------");
	
	}
	@Test
	public void getSubnets() throws ClientProtocolException, IOException {
		Subnets response = super.get(Subnets);
		// do other assertions
		
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		System.out.println("---------------------------------------------------------------------------------------------");
	
	}
}
