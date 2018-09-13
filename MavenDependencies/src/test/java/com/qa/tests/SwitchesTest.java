package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class SwitchesTest extends TestBase<Switches, Object> {
	public SwitchesTest() {
		super(Switches.class, Object.class);
	}

	private static String switches =
		TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_switches");
	private static String SWitchID =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("servcieURL_SWitchID");
	private static String SwitchPorts =
			TestBase.prop.getProperty("API_URL") + TestBase.prop.getProperty("serviceURL_SwitchPorts");
		
	@Test
	public void getSwitch() throws ClientProtocolException, IOException {
		Switches response = super.get(switches);
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
	public void getSwitchID() throws ClientProtocolException, IOException {
		Switches response = super.get(SWitchID);
		// do other assertions
		// 1. Has return value
		Assert.assertNotNull(response);
		
		// 3. Has non-empty name
		Assert.assertNotNull(response.name);
		Assert.assertTrue(response.name.length() > 0);		

		System.out.println("---------------------------------------------------------------------------------------------");
	}
	@Test
	public void getSwitchPorts() throws ClientProtocolException, IOException {
		Switches response = super.get(SwitchPorts);
		// do other assertions
		// 1. Has return value
		Assert.assertNotNull(response);

		// 2. Has non-empty name
		Assert.assertTrue(response.items.size() > 0);
		// 3. Has non-empty name
		Assert.assertNotNull(response.items.get(0).portType);
		Assert.assertTrue(response.items.get(0).portType.length() > 0);		

		System.out.println("---------------------------------------------------------------------------------------------");
	}
}

