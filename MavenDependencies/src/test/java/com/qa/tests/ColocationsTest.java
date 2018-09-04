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

public class ColocationsTest extends TestBase<Colocations, Object> {
	private static String getUrl = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_colocationPortTypes");
	private static String getUrl1 = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL-colocationCapacity");
	private static String getUrl2 = TestBase.prop.getProperty("URL_integration")
			+ TestBase.prop.getProperty("serviceURL_colocationSwitch");
	

	public ColocationsTest() {
		super(Colocations.class, Object.class);
	}

	@Test
	public void getColocations() throws ClientProtocolException, IOException {
		Colocations response = super.get(getUrl);

		

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getColocationsCapacity() throws ClientProtocolException, IOException {
		super.get(getUrl1, TestBase.RESPONSE_STATUS_CODE_200);
		;

		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	@Test
	public void getColocationsSwitch() throws ClientProtocolException, IOException {
		
		super.get(getUrl2, TestBase.RESPONSE_STATUS_CODE_200);

		// do other assertions

		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}
}



