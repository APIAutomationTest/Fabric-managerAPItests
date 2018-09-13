package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import com.qa.base.TestBase;

public class VirtualNetworksTest extends TestBase<VirtualNetworks, Object> {
	private static String virtualNetworks = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_virtualNetworks");
	private static String getUrl_badCustomer = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_badcustomernetworks");
	private static String getUrl_badFabric = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_badfabrictnetworks");
	private static String VirtualNetworkTypes = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_VirtualNetworkTypes");
	private static String VirtualNetworksID = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_VirtualNetworksID");
	private static String VirtualNetworkGroups = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_VirtualNetworkGroups");
	private static String VirtualNetworkGroupsId = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_VirtualNetworkGroupsId");
	private static String VirtualNetworkIDGroups = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_VirtualNetworkIDGroups");
	
	public VirtualNetworksTest() {
		super(VirtualNetworks.class, Object.class);
	}

	@Test
	public void get() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(virtualNetworks);
		

		// 1. Has return value
		Assert.assertNotNull(response);

		//2. Has non-empty items
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);
		
		
		// Since we're using Jackson for HTTP requests, we check the response structure implicitly.
		// No need the assert here.

		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getNegativeCustomer() throws ClientProtocolException, IOException {
		super.get(getUrl_badCustomer, TestBase.RESPONSE_STATUS_CODE_404);
		
		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getNegativeFabric() throws ClientProtocolException, IOException {
		super.get(getUrl_badFabric, TestBase.RESPONSE_STATUS_CODE_404);
		
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getBadAccessToken() throws ClientProtocolException, IOException {
		String correctAccessToken = TestBase.getAccessToken();
		// Change the access token to a bad one
		TestBase.accessToken = TestBase.getAccessToken(prop.getProperty("virtualNetworkskauth_client_id"),
				prop.getProperty("virtualNetworksauth_client_secret"));

		super.get(virtualNetworks, TestBase.RESPONSE_STATUS_CODE_404);

		// Restore the original access token after testing
		TestBase.accessToken = correctAccessToken;

		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getVirtualNetworkTypes() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(VirtualNetworkTypes);

		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		
		


		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getVirtualNetworkID() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(VirtualNetworksID);

		// 1. Has return value
		Assert.assertNotNull(response);

		// 3. Has non-empty name
		Assert.assertNotNull(response.name);
		Assert.assertTrue(response.name.length() > 0);	
		
		


		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getVirtualNetworkGroups() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(VirtualNetworkGroups);
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		
		


		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getVirtualNetworkGroupsId() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(VirtualNetworkGroupsId);

		// 1. Has return value
		Assert.assertNotNull(response);

		// 3. Has non-empty name
		Assert.assertNotNull(response.name);
		Assert.assertTrue(response.name.length() > 0);	
		
				
		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getVirtualNetworkIdGroups() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(VirtualNetworkIDGroups);

		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).name);
		Assert.assertTrue(response.items.get(0).name.length() > 0);		

		


		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
}
