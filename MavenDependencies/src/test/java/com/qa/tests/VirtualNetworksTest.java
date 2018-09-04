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

public class VirtualNetworksTest extends TestBase<VirtualNetworks, Object> {
	private static String getUrl = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_virtualNetworks");
	private static String getUrl_badCustomer = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_badcustomernetworks");
	private static String getUrl_badFabric = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_badfabrictnetworks");
	// TestBase.prop.getProperty("URL_integration") +
	// TestBase.prop.getProperty("serviceURL_badfabrictnetworks");

	public VirtualNetworksTest() {
		super(VirtualNetworks.class, Object.class);
	}

	@Test
	public void get() throws ClientProtocolException, IOException {
		VirtualNetworks response = super.get(getUrl);

		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertNotNull(response.name);
		Assert.assertTrue(response.name.length() > 0);

		// 3. Has non-empty items
		Assert.assertTrue(response.items.size() > 0);
		
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
	}

	@Test
	public void getBadAccessToken() throws ClientProtocolException, IOException {
		String correctAccessToken = TestBase.getAccessToken();
		// Change the access token to a bad one
		TestBase.accessToken = TestBase.getAccessToken(prop.getProperty("virtualNetworkskauth_client_id"),
				prop.getProperty("virtualNetworksauth_client_secret"));

		super.get(getUrl, TestBase.RESPONSE_STATUS_CODE_404);

		// Restore the original access token after testing
		TestBase.accessToken = correctAccessToken;

		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

}
