package com.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class CustomersTest extends TestBase<Customers, Object> {
	public CustomersTest() {
		super(Customers.class, Object.class);
	}

	private static String url =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_customers");
	private static String getUrl2 = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_CustomerLocations");
	
	//public CustomersTest() {
		//super(Customers.class, Object.class);
	@Test
	public void getCustomers() throws ClientProtocolException, IOException {
		Customers response = super.get(url);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	/*
	@Test
	public void post() throws ClientProtocolException, IOException {
		Random r = new Random();
		final int accountNumber = r.nextInt(100);
		final int productServiceId = r.nextInt(100);
		String postBody = new JSONObject() {{
			put("accountNumber", accountNumber);
			put("customerName", "CustomerName");
			put("productServiceIds", Collections.singleton(new JSONObject() {{
				put("id", productServiceId);
			}}));
		}}.toString();
		
		Object response = super.post(url, postBody);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
		*/
	
	@Test
	public void getComputeHypervisor() throws ClientProtocolException, IOException {
		super.get(getUrl2, TestBase.RESPONSE_STATUS_CODE_200);
		;

		// do other assertions

		System.out.println(
			"---------------------------------------------------------------------------------------------");
}
}