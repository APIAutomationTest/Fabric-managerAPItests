package com.qa.tests;

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
	private static String getUrl =
		TestBase.prop.getProperty("URL_integration") + TestBase.prop.getProperty("serviceURL_networks");
	
	//1
	private static String getPostUrl() {
		return TestBase.prop.getProperty("URL_integration") +
				String.format(TestBase.prop.getProperty("serviceURL_postNetworks"));
	}
	
	public NetworksTest() {
		super(Networks.class, Object.class);
	}
	
	@Test
	public void get() throws ClientProtocolException, IOException {
		Networks response = super.get(getUrl);
		// do other assertions
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	/*
	@Test
	public void post() throws ClientProtocolException, IOException {
		String postBody = new JSONObject() {{
			put("vlans", new JSONObject() {{
				
				put("vlan", TestHelper.randomInt(1000));
				put("name", TestHelper.randomString(5), "computeNodeGroups","" ,"networkGroups","");
			}

			private void put(String string, String string2, String string3, String string4, String string5,
					String string6) {
				// TODO Auto-generated method stub
				
			}});
		}}.toString();
		
		
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	*/
}
