package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class EntitlementsTest extends TestBase<Entitlements, Object> {
	public EntitlementsTest() {
		super(Entitlements.class, Object.class);
	}

	private static String Entitlements =
		TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_Entitlements");
	
	private static String CutomerEntitlements =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_CutomerEntitlements");
		
	private static String CustomerIdEntitlements =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_CustomerIdEntitlements");
	private static String CustomFabEntitlements =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_CustomFabEntitlements");
	private static String FabricIdEntitlements =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_FabricIdEntitlements");
		
	@Test
	public void getEntitlements() throws ClientProtocolException, IOException {
		Entitlements response = super.get(Entitlements);
		 // 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.entitlements.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.entitlements.get(0).name);
		Assert.assertTrue(response.entitlements.get(0).name.length() > 0);
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	@Test
	public void getCustomersEntitlemens() throws ClientProtocolException, IOException {
		Entitlements response = super.get(CutomerEntitlements);
		 // 1. Has return value
		Assert.assertNotNull(response);
		
		// 2. Has non-empty name
		Assert.assertTrue(response.fabrics.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.fabrics.get(0).name);
		Assert.assertTrue(response.fabrics.get(0).name.length() > 0);		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getCustomersIdEntitlemens() throws ClientProtocolException, IOException {
		Entitlements response = super.get(CustomerIdEntitlements);
		 // 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.fabrics.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.fabrics.get(0).name);
		Assert.assertTrue(response.fabrics.get(0).name.length() > 0);
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getCustomFabEntitlements() throws ClientProtocolException, IOException {
		Entitlements response = super.get(CustomFabEntitlements);
		 // 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.fabrics.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.fabrics.get(0).name);
		Assert.assertTrue(response.fabrics.get(0).name.length() > 0);		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getFabricIdEntitlements() throws ClientProtocolException, IOException {
		Entitlements response = super.get(FabricIdEntitlements);
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.entitlements.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.entitlements.get(0).name);
		Assert.assertTrue(response.entitlements.get(0).name.length() > 0);
				
		System.out.println("---------------------------------------------------------------------------------------------");
	}
}
