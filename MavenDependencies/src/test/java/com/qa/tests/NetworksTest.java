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

public class NetworksTest extends TestBase<Networks, Object> {
	private static String networks =
		TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_networks");
	private static String ChildNetworks = TestBase.prop.getProperty("API_URL")
			+ TestBase.prop.getProperty("serviceURL_ChildNetworks");
	
	
	
	//1
	private static String postNetworks() {
		return TestBase.prop.getProperty("API_URL") +
				String.format(TestBase.prop.getProperty("serviceURL_postNetworks"));
	}
	
	public NetworksTest() {
		super(Networks.class, Object.class);
	}
	
	@Test
	public void getNetwork() throws ClientProtocolException, IOException {
		Networks response = super.get(networks);
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
	public void getChildNetworks() throws ClientProtocolException, IOException {
		Networks response = super.get(ChildNetworks);
		// do other assertions
		// 1. Has return value
		Assert.assertNotNull(response);

		System.out.println("---------------------------------------------------------------------------------------------");
	}
	@Test
	public void post() throws ClientProtocolException, IOException {
		String postBody = new JSONObject() {{
			put("vlans", new JSONObject() {{
				
				put("vlan", TestHelper.randomInt(1000));
				put("name", TestHelper.randomString(5), "computeNodeGroups","" ,"networkGroups","");
			}

			private void put(String string, String string2, String string3, String string4, String string5,
					String string6) {
				
				
			}});
		}}.toString();
		
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	
}



