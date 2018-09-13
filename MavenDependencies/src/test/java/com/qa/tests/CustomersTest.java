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

public class CustomersTest extends TestBase<Customers, Object> {
	public CustomersTest() {
		super(Customers.class, Object.class);
	}

	private static String customers =
		TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_customers");
	private static String CustomerLocations = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_CustomerLocations");
	
	
	@Test
	public void getCustomers() throws ClientProtocolException, IOException {
		Customers response = super.get(customers);
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
		
		Object response = super.post(customers, postBody);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
	@Test
	public void getCustomerLocation() throws ClientProtocolException, IOException {
		Customers response = super.get(CustomerLocations);
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
